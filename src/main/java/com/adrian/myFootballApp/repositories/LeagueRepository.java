package com.adrian.myFootballApp.repositories;

import com.adrian.myFootballApp.model.League;
import org.springframework.data.repository.CrudRepository;

public interface LeagueRepository extends CrudRepository<League,Long> {
}
