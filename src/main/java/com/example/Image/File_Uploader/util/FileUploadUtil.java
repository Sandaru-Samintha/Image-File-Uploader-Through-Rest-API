package com.example.Image.File_Uploader.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUploadUtil {

        //File upload කරන්න upload  location එකක්(File location )-->uploadDir, upload  කරන file එකේ නම-->fileName,spring web depency එක හරහා එන insatance එකක්-->multipartFile
    public static void saveFile(String uploadDir, String fileName , MultipartFile multipartFile) throws IOException {

        //Upload කරන path එක
        Path uploadPath = Paths.get("E:\\Self Learned Languages\\springBoot-my practices\\Image_File-Uploader\\src\\main\\resources\\static\\"+ uploadDir);//කොහෙට upload කරන file ටික යන්න ඕන කියන directory එක දානව get එක ඇතුලට

        //මුලින්ම path  එක හදන්න කලින් check  කරනව ඒ කියන path එක තියනවද කියල
        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath); //add exception to method signature -->එහෙම path එකක් නැත්තම් createDirectory එකෙන් path එක හදා ගන්නව.
        }


        //File එක upload  කරන mechanism එක
        try (InputStream inputStream =multipartFile.getInputStream()){
            Path filePath = uploadPath.resolve(fileName);
            //File එක copy  කරන වැඩේ
            Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);//කලින් copy වෙච්ච එකක් තියනවනම් දෙපාරක් copy කරන්න එපා කියන්න තමා StandardCopyOption.REPLACE_EXISTING දාන්නේ
        }catch (IOException ioException){

        }

    }
}
