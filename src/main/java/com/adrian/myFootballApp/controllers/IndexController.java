package com.adrian.myFootballApp.controllers;

import com.adrian.myFootballApp.model.League;
import com.adrian.myFootballApp.service.LeagueService;
import com.adrian.myFootballApp.service.PlayerService;
import com.adrian.myFootballApp.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class IndexController {

    private PlayerService playerService;
    private TeamService teamService;
    private LeagueService leagueService;

    @Autowired
    public IndexController(PlayerService playerService, TeamService teamService, LeagueService leagueService) {
        this.playerService = playerService;
        this.teamService = teamService;
        this.leagueService = leagueService;
    }

    @RequestMapping({"/","/index",""})
    public String getIndex(Model model){
        List<League> leagues = new ArrayList<League>(Arrays.asList(new League("EPL")));
        model.addAttribute("teams",teamService.getTeams());
        model.addAttribute("leagues",leagueService.getAllLeagues());
        return "index";
    }
}
