package com.adrian.myFootballApp.service;

import com.adrian.myFootballApp.model.Player;
import com.adrian.myFootballApp.model.Team;
import com.adrian.myFootballApp.repositories.PlayerRepository;
import com.adrian.myFootballApp.repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService{

    private TeamRepository teamRepository;
    private PlayerRepository playerRepository;

    public TeamServiceImpl(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Team> getTeams() {
        List<Team> result = new ArrayList<>();
        teamRepository.findAll().iterator().forEachRemaining(result::add);
        return result;
    }

    @Override
    public Team findById(Long id) {
        Optional<Team> optionalTeam = teamRepository.findById(id);

        if (!optionalTeam.isPresent()){
            throw new RuntimeException("Recipe not found for id: " + id);
        }

        return optionalTeam.get();
    }

    @Override
    public List<Player> findPlayers(Long teamId) {
        List<Player> players = playerRepository.findByTeamId(teamId);

        return players;
    }
}
