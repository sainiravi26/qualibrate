package com.ravi.assignment.qualibrate.service;

import com.ravi.assignment.qualibrate.domain.User;
import com.ravi.assignment.qualibrate.domain.repository.UserRepository;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final FileService fileService;

    public UserService(UserRepository userRepository, UserMapper userMapper, FileService fileService) {

        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.fileService = fileService;
    }

    public UserDTO createUser(UserDTO user) {

        return userMapper.userToUserDTO(userRepository.save(userMapper.userDTOToUser(user)));
    }

    public Optional<UserDTO> getUser(Long id) {

        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return Optional.of(userMapper.userToUserDTO(user.get()));
        }
        return Optional.empty();
    }

    public boolean deleteUser(Long id) {

        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            fileService.deleteUserFiles(user.get());
            return true;
        }
        return false;
    }

    public PageResult<UserDTO> findUsers(int page, int pageSize) {

        return new PageResult<>(
                userRepository.findAll(PageRequest.of(page, pageSize)).map(user -> userMapper.userToUserDTO(user)).toList());
    }
}
