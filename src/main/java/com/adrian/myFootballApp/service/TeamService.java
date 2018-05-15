package com.adrian.myFootballApp.service;

import com.adrian.myFootballApp.model.Player;
import com.adrian.myFootballApp.model.Team;

import java.util.List;

public interface TeamService {
    public List<Team> getTeams();

    public Team findById(Long id);
    public List<Player> findPlayers(Long teamId);
}
