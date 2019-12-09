package com.ravi.assignment.qualibrate.service;

import com.ravi.assignment.qualibrate.domain.File;
import com.ravi.assignment.qualibrate.domain.User;
import com.ravi.assignment.qualibrate.domain.repository.FileRepository;
import com.ravi.assignment.qualibrate.domain.repository.UserRepository;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.multipart.MultipartFile;

public class FileService {

    private final FileStorageService fileStorageService;
    private final FileTypeChecker fileTypeChecker;
    private final FileRepository fileRepository;
    private final UserRepository userRepository;
    private final FileMapper fileMapper;

    public FileService(FileRepository fileRepository, UserRepository userRepository, FileMapper fileMapper,
            FileStorageService fileStorageService, FileTypeChecker fileTypeChecker) {

        this.fileStorageService = fileStorageService;
        this.fileTypeChecker = fileTypeChecker;
        this.fileRepository = fileRepository;
        this.userRepository = userRepository;
        this.fileMapper = fileMapper;
    }

    public void deleteUserFiles(User user) {

        fileRepository.deleteByUser(user.getId());
    }

    public Optional<FileDTO> getFile(Long userId, Long fileId) {

        Optional<User> user = userRepository.findById(userId);
        // only check if user is present
        if (user.isPresent()) {
            Optional<File> file = fileRepository.findById(fileId);
            if (file.isPresent()) {
                return Optional.of(fileMapper.fileToFileDTO(file.get()));
            }
            return Optional.empty();
        }
        throw new ResourceNotFoundException(String.format("User with id  %d not found", userId));
    }

    public PageResult<FileDTO> getUserFiles(Long userId) {

        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return new PageResult<>(
                    fileRepository.findByUser(user.get()).stream().map(file -> fileMapper.fileToFileDTO(file)).collect(
                            Collectors.toList()));
        }
        throw new ResourceNotFoundException(String.format("User with id  %d not found", userId));
    }

    public FileDTO createFile(Long userId, MultipartFile multipartFile) throws IOException {

        String mimeType = fileTypeChecker.getMimeType(multipartFile.getOriginalFilename());
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            File file = new File();
            file.setUser(user.get());
            file.setName(multipartFile.getOriginalFilename());
            file.setUuid(UUID.randomUUID());
            file.setPath(fileStorageService.store(file.getUuid(), multipartFile));
            file.setMime(mimeType);
            file = fileRepository.save(file);
            return fileMapper.fileToFileDTO(file);
        }

        throw new ResourceNotFoundException(String.format("User with id  %d not found", userId));
    }
}
