package com.adrian.myFootballApp.service;

import com.adrian.myFootballApp.commands.PlayerCommand;
import com.adrian.myFootballApp.model.Player;

import java.util.List;

public interface PlayerService {
    List<Player> getAllPlayers();
    PlayerCommand savePlayerCommand(PlayerCommand command);
    Player findById(Long id);
}
