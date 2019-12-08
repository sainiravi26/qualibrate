package com.ravi.assignment.qualibrate.service;

import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;

import javax.activation.MimetypesFileTypeMap;

public class FileTypeChecker {

    private final MimetypesFileTypeMap fileTypeMap;
    private Set<String> allowedFileTypes = newHashSet("image/png", "application/pdf", "image/jpeg", "image/gif", "text/plain");

    public FileTypeChecker(MimetypesFileTypeMap fileTypeMap) {

        this.fileTypeMap = fileTypeMap;
    }

    public String getMimeType(String fileName) {

        String mimeType = fileTypeMap.getContentType(fileName);
        if (!allowedFileTypes.contains(mimeType)) {
            throw new InvalidFileTypeException(String.format("%s file is not allowed", fileName));
        }
        return mimeType;
    }
}
