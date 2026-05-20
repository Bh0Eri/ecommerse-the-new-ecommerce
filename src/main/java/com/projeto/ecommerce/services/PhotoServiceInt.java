package com.projeto.ecommerce.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PhotoServiceInt {

    String saveP(MultipartFile file) throws IOException;

}
