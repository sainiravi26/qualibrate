package com.ravi.assignment.qualibrate.configuration;

import com.ravi.assignment.qualibrate.domain.repository.UserRepository;
import com.ravi.assignment.qualibrate.service.DiskFileStorageService;
import com.ravi.assignment.qualibrate.service.UserMapper;
import com.ravi.assignment.qualibrate.service.UserService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModuleConfig {

    @Bean
    DiskFileStorageService getDiskFileStorageService() {

        return new DiskFileStorageService();
    }

    @Bean
    UserService getUserService(UserRepository userRepository, UserMapper userMapper,
            DiskFileStorageService diskFileStorageService) {

        return new UserService(userRepository, userMapper, diskFileStorageService);
    }
}
