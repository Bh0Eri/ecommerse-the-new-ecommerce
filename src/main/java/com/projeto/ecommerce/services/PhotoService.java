package com.projeto.ecommerce.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class PhotoService implements PhotoServiceInt{

    @Value("${upload.dir}")
    private String uploadDir;

    @Override
    public String saveP(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String extension = fileName.substring(fileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString() + "." + extension;

        Path directory = Path.of(uploadDir);
        Files.createDirectories(directory);

        Path pathUrl = directory.resolve(newFileName);

        Files.copy(file.getInputStream(), pathUrl, StandardCopyOption.REPLACE_EXISTING);

        return uploadDir + "/" + newFileName;

    }
}
