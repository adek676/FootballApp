package com.adrian.myFootballApp.bootstrap;

import com.adrian.myFootballApp.model.League;
import com.adrian.myFootballApp.model.Player;
import com.adrian.myFootballApp.model.Team;
import com.adrian.myFootballApp.repositories.LeagueRepository;
import com.adrian.myFootballApp.repositories.PlayerRepository;
import com.adrian.myFootballApp.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitialization implements ApplicationListener<ContextRefreshedEvent>{

    private PlayerRepository playerRepository;
    private TeamRepository teamRepository;
    private LeagueRepository leagueRepository;

    @Autowired
    public DataInitialization(PlayerRepository playerRepository, TeamRepository teamRepository, LeagueRepository leagueRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
        this.leagueRepository = leagueRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        setInitialData();
    }

    @Transactional
    public void setInitialData(){
        List<Team> teamsToSave = new ArrayList<>();

        League l = new League("BPL");
        leagueRepository.save(l);

        Player tempPlayer = new Player("David","Beckham");
        Player tempPlayer2  = new Player("Paul","Scholes");
        Team tempTeam = new Team("Manchester United","England");
        Team tempTeam2 = new Team("Arsenal Londyn","England");
        Team tempTeam3 = new Team("Liverpool FC","England");
        tempTeam.setLeague(l);
        teamsToSave.add(tempTeam);
        teamRepository.saveAll(teamsToSave);
        tempPlayer.setTeam(tempTeam);
        tempPlayer2.setTeam(tempTeam);
        playerRepository.save(tempPlayer);
        playerRepository.save(tempPlayer2);
    }
}
