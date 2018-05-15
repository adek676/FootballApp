package com.adrian.myFootballApp.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    public void saveImage(Long playerId, MultipartFile file);
}
