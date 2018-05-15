package com.adrian.myFootballApp.bootstrap;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MultiPFile {
    public static void readBytes(File f)throws IOException{
        Path p  = Paths.get(f.toURI());
        byte[] bytes = Files.readAllBytes(p);
        for (byte b : bytes){
            System.out.print(String.format("%02X",b));
        }
    }

    public static void main(String[] args) throws IOException{
        File f = new File("C:/Users/adrian/Desktop/becks_sm.jpg");
        readBytes(f);
    }
}
