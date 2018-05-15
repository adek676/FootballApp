package com.adrian.myFootballApp.service;

import com.adrian.myFootballApp.commands.PlayerCommand;
import com.adrian.myFootballApp.converters.PlayerCommandToPlayer;
import com.adrian.myFootballApp.model.Player;
import com.adrian.myFootballApp.repositories.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    private static final Logger logger = LoggerFactory.getLogger(PlayerServiceImpl.class);

    private PlayerRepository playerRepository;
    private PlayerCommandToPlayer playerCommandToPlayer;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, PlayerCommandToPlayer playerCommandToPlayer) {
        this.playerRepository = playerRepository;
        this.playerCommandToPlayer = playerCommandToPlayer;
    }

    @Override
    public List<Player> getAllPlayers() {
        List<Player> result = new ArrayList<>();
        playerRepository.findAll().iterator().forEachRemaining(result::add);
        return result;
    }

    @Override
    public PlayerCommand savePlayerCommand(PlayerCommand command) {

        Player detachedPlayer = playerCommandToPlayer.convert(command);
        Player savedPlayer = playerRepository.save(detachedPlayer);
        logger.info("saved Player: " + savedPlayer.getFirstName() + " " + savedPlayer.getLastName());

        return command;
    }

    @Override
    public Player findById(Long id) {
        Player p = playerRepository.findById(id).get();
        return p;
    }
}
