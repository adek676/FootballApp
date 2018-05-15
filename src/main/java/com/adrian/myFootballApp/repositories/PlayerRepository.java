package com.adrian.myFootballApp.repositories;

import com.adrian.myFootballApp.model.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player,Long> {
        List<Player> findByTeamId(Long id);
}
