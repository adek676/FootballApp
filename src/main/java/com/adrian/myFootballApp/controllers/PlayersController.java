package com.adrian.myFootballApp.controllers;

import com.adrian.myFootballApp.commands.PlayerCommand;
import com.adrian.myFootballApp.model.Player;
import com.adrian.myFootballApp.model.Team;
import com.adrian.myFootballApp.service.ImageService;
import com.adrian.myFootballApp.service.PlayerService;
import com.adrian.myFootballApp.service.TeamService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
public class PlayersController {
    private final static Logger logger = LoggerFactory.getLogger(PlayersController.class);
    private PlayerService playerService;
    private TeamService teamService;
    private ImageService imageService;
    private static final Logger log = LoggerFactory.getLogger(PlayersController.class);

    @Autowired
    public PlayersController(PlayerService playerService, TeamService teamService, ImageService imageService) {
        this.playerService = playerService;
        this.teamService = teamService;
        this.imageService = imageService;
    }

    @RequestMapping({"/getPlayers","allPlayers"})
    public String getPlayers(Model model){
        model.addAttribute("players",playerService.getAllPlayers());
        return "players/show";
    }

    @GetMapping("/newPlayer")
    public String newPlayer(Model model){
        logger.info("inside /newPlayer");
        model.addAttribute("player",new PlayerCommand());
        return "playerForm";
    }

    @PostMapping("player")
    public String saveOrUpdate(@ModelAttribute("player") PlayerCommand command){
        logger.info("inside saveOrUpdate");
        playerService.savePlayerCommand(command);

        return "redirect:/allPlayers";
    }

    @GetMapping("/testImage")
    public void renderPlayer(HttpServletResponse response)
                            throws IOException{
        List<Player> playerList = teamService.findPlayers(Long.valueOf(1));

        if (playerList != null){
            byte[] byteArray = new byte[playerList.get(0).getImg().length];
            int i = 0;

            for (Byte b : playerList.get(0).getImg()){
                byteArray[i++] = b;
            }
            log.info("byte array size : " + playerList.size());
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is,response.getOutputStream());
        }
    }

    @GetMapping("player/{id}/image")
    public String showUploadForm(@PathVariable String id, Model model){
        model.addAttribute("player",playerService.findById(Long.valueOf(id)));

        return "players/imageuploadform";
    }

    @PostMapping("player/{id}/image")
    public String handleImagePost(@PathVariable String id, @RequestParam("imagefile") MultipartFile file){
        imageService.saveImage(Long.valueOf(id),file);

        return "redirect:teams/1/show";
    }

    @GetMapping("/test2")
    public void getImageAsByteArray(HttpServletResponse response) throws IOException {
        File f = new File("C:/Users/adrian/Desktop/becks.jpg");
        InputStream in = new FileInputStream(f);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }
}