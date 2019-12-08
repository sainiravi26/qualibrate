package com.ravi.assignment.qualibrate.configuration;

import com.ravi.assignment.qualibrate.domain.repository.FileRepository;
import com.ravi.assignment.qualibrate.domain.repository.UserRepository;
import com.ravi.assignment.qualibrate.service.DiskFileStorageService;
import com.ravi.assignment.qualibrate.service.FileMapper;
import com.ravi.assignment.qualibrate.service.FileService;
import com.ravi.assignment.qualibrate.service.FileStorageService;
import com.ravi.assignment.qualibrate.service.FileTypeChecker;
import com.ravi.assignment.qualibrate.service.UserMapper;
import com.ravi.assignment.qualibrate.service.UserService;

import javax.activation.MimetypesFileTypeMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModuleConfig {

    @Bean
    public DiskFileStorageService getDiskFileStorageService() {

        return new DiskFileStorageService();
    }

    @Bean
    public FileService getFileService(FileRepository fileRepository, UserRepository userRepository, FileMapper fileMapper,
            FileStorageService fileStorageService, FileTypeChecker fileTypeChecker) {

        return new FileService(fileRepository, userRepository, fileMapper, fileStorageService, fileTypeChecker);
    }

    @Bean
    public UserService getUserService(UserRepository userRepository, UserMapper userMapper, FileService fileService) {

        return new UserService(userRepository, userMapper, fileService);
    }

    @Bean
    public FileTypeChecker getFileTypeChecker(MimetypesFileTypeMap fileTypeMap) {

        return new FileTypeChecker(fileTypeMap);
    }

    @Bean
    public MimetypesFileTypeMap getMimetypesFileTypeMap() {

        MimetypesFileTypeMap fileTypeMap = new MimetypesFileTypeMap();
        // add additional file types
        fileTypeMap.addMimeTypes("application/json json");
        fileTypeMap.addMimeTypes("image/png PNG");
        fileTypeMap.addMimeTypes("application/pdf pdf PDF");
        return fileTypeMap;
    }
}
