package com.example.Image.File_Uploader.controller;

import com.example.Image.File_Uploader.util.FileUploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

@RequestMapping("/api/v1/img")
@Controller
public class ImageUploadController {
    @PostMapping("/upload")   //@RequestParam -- upload කරන image එක අල්ල ගන්න --->ඒකට key word එකක් දාගන්නව files කියල --> as form data
    public void saveImage(@RequestParam("files")MultipartFile[] files){
        String uploadDir = "ProfileImageFolder"; //File upload කරන directory එකේ නම fileUploadUtil එකට යවන නම දෙන තැන

        //Array stream කරල තමා දාන්නේ
        Arrays.asList(files).stream().forEach(file->{  //Foreach එකකින් file එක ගන්නවා
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));  //ඒ ඇසුරි file name එක ගන්නව
            System.out.println(fileName);
            try{
                FileUploadUtil.saveFile(uploadDir,fileName,file); // Return කරනව අදාල ටික FileUploadUtil එකේ හදා ගත්ත ටික
            } catch (IOException ioException) {
                throw new RuntimeException(ioException);
            }
        });
    }
}
