package com.ravi.assignment.qualibrate.configuration;

import com.ravi.assignment.qualibrate.service.FileService;
import com.ravi.assignment.qualibrate.service.UserService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModuleConfig {

    @Bean
    UserService getUserService() {

        return new UserService();
    }

    @Bean
    FileService getFileService() {

        return new FileService();
    }
}
