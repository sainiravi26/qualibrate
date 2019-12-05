package com.ravi.assignment.qualibrate.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserService {

    public UserDTO createUser(UserDTO user) {

        return user;
    }

    public UserDTO getUser(Long id) {

        return null;
    }

    public Page<UserDTO> findUsers(Pageable pageable) {

        return null;
    }
}
