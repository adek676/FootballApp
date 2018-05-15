package com.adrian.myFootballApp.service;

import com.adrian.myFootballApp.model.Player;
import com.adrian.myFootballApp.repositories.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {

    private PlayerRepository playerRepository;
    private final Logger log = LoggerFactory.getLogger(ImageServiceImpl.class);

    @Autowired
    public ImageServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    @Transactional
    public void saveImage(Long playerId, MultipartFile file) {
        try{
            Player p = playerRepository.findById(playerId).get();
            Byte[] bytes = new Byte[file.getBytes().length];

            int i = 0;
            for (Byte b : file.getBytes()){
                bytes[i++] = b;
            }

            p.setImg(bytes);
            playerRepository.save(p);

        }catch (IOException e){
            log.info("Cannot parse image");
            e.printStackTrace();
        }
    }
}
