package com.adrian.myFootballApp.repositories;

import com.adrian.myFootballApp.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team,Long> {
}
