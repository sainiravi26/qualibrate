package com.ravi.assignment.qualibrate.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

public class DiskFileStorageService implements FileStorageService {

    @Value("${file.storage.location}")
    private String fileStorageLocation;

    @Override
    public String store(UUID uuid, MultipartFile multipartFile) throws IOException {

        File fileStoreLoc = getFileStorageLocation();

        if (!fileStoreLoc.exists()) {
            fileStoreLoc.mkdirs();
        }

        File file = new File(fileStoreLoc.getAbsolutePath(), uuid.toString());
        multipartFile.transferTo(file);
        return file.getAbsolutePath();
    }

    File getFileStorageLocation() {

        return new File(fileStorageLocation);
    }
}
