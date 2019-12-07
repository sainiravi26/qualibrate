package com.ravi.assignment.qualibrate.service;

import com.ravi.assignment.qualibrate.domain.File;
import com.ravi.assignment.qualibrate.domain.User;
import com.ravi.assignment.qualibrate.domain.repository.UserRepository;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final FileStorageService fileStorageService;

    //private Set<String> allowedFileTypes = .newHashSet("image/png", "application/pdf", "image/jpeg", "image/gif", "text/plain");

    public UserService(UserRepository userRepository, UserMapper userMapper, FileStorageService fileStorageService) {

        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.fileStorageService = fileStorageService;
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

    public PageResult<UserDTO> findUsers(int page, int pageSize) {

        return new PageResult<>(
                userRepository.findAll(PageRequest.of(page, pageSize)).map(user -> userMapper.userToUserDTO(user)).toList());
    }

    public FileDTO createFile(Long userId, MultipartFile multipartFile) throws IOException {

        //        String fileType = multipartFile.
        //        if (!allowedFileTypes.contains(fileType)) {
        //
        //        }

        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            File file = new File();
            file.setName(multipartFile.getOriginalFilename());
            file.setUuid(UUID.randomUUID());
            file.setPath(fileStorageService.store(file.getUuid(), multipartFile));
        }

        return null;
    }
}
