package com.adrian.myFootballApp.service;

import com.adrian.myFootballApp.model.League;
import com.adrian.myFootballApp.repositories.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeagueServiceImpl implements LeagueService{
    private LeagueRepository leagueRepository;

    @Autowired
    public LeagueServiceImpl(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    @Override
    public List<League> getAllLeagues() {
        List<League> result = new ArrayList<>();
        leagueRepository.findAll().forEach(result::add);
        return result;
    }
}
