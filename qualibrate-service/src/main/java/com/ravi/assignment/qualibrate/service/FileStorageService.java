package com.ravi.assignment.qualibrate.service;

import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    String store(UUID uuid, MultipartFile multipartFile) throws IOException;
}
