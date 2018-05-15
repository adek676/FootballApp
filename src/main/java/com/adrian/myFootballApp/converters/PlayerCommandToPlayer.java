package com.adrian.myFootballApp.converters;

import com.adrian.myFootballApp.commands.PlayerCommand;
import com.adrian.myFootballApp.model.Player;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class PlayerCommandToPlayer implements Converter<PlayerCommand, Player> {

    @Nullable
    @Override
    public Player convert(PlayerCommand command) {
        if (command == null){
            return null;
        }
        Player player = new Player();
        player.setFirstName(command.getFirstName());
        player.setLastName(command.getLastName());
        player.setAge(command.getAge());

        return player;
    }
}
