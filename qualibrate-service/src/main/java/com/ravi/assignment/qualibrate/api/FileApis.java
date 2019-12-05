package com.ravi.assignment.qualibrate.api;

import com.ravi.assignment.qualibrate.service.FileDTO;
import com.ravi.assignment.qualibrate.service.FileService;

import javax.validation.Valid;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(path = "/files")
public class FileApis {

    private final FileService fileService;

    FileApis(FileService fileService) {

        this.fileService = fileService;
    }

    @Operation(summary = "Uploads a new file into Qualibrate", description =
            " There is a restricting policy for the types of files that can be uploaded in the platform. \n "
                    + "Allowance: [.pdf, .jpeg, .jpg, .gif, .png, .txt]", tags = {
            "files" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "File is successfully uploaded", headers = {
                    @Header(name = "location", description = "Location of created file resource") }) })
    @PostMapping(consumes = { "application/json" })
    public ResponseEntity<Object> createFile(@Valid FileDTO file) {

        try {
            //fileService.createUser(file);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
        }
        //return created(user);
        return null;
    }
}
