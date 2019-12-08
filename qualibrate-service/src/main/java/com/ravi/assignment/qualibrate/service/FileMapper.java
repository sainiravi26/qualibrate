package com.ravi.assignment.qualibrate.service;

import com.ravi.assignment.qualibrate.domain.File;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileMapper {

    FileDTO fileToFileDTO(File file);
}
