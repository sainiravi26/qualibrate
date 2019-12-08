package com.ravi.assignment.qualibrate.api;

import com.ravi.assignment.qualibrate.domain.IdAware;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public final class ResponseEntityBuilder {

    public static <T extends IdAware> ResponseEntity<Object> created(T createdEntity) {

        // Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdEntity.getId())
                .toUri();
        //Send location in response
        return ResponseEntity.created(location).body(createdEntity);
    }
}
