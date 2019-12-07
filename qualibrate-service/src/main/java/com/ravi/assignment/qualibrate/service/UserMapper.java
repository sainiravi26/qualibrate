package com.ravi.assignment.qualibrate.service;

import com.ravi.assignment.qualibrate.domain.User;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToUserDTO(User user);

    User userDTOToUser(UserDTO userDTO);
}
