package com.adrian.myFootballApp.controllers;

import com.adrian.myFootballApp.model.Player;
import com.adrian.myFootballApp.model.Team;
import com.adrian.myFootballApp.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class TeamController {
    private final static Logger log = LoggerFactory.getLogger(TeamController.class);
    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @RequestMapping("/team/{teamId}/show")
    public String getTeamView(@PathVariable String teamId, Model model){
        log.info("inside getTeamView controller");
        List<Player>  players = teamService.findPlayers(Long.valueOf(teamId));
        model.addAttribute("team",teamService.findById(Long.valueOf(teamId)));
        model.addAttribute("players",players);
        log.info("" + players.size());
        return "teams/show";
    }


}
