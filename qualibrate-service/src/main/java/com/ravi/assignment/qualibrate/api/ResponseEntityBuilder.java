package com.ravi.assignment.qualibrate.api;

import com.ravi.assignment.qualibrate.domain.IdAware;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public final class ResponseEntityBuilder {

    public static <T extends IdAware> ResponseEntity<Object> created(T createdEntity) {

        return created(createdEntity, true);
    }

    public static <T extends IdAware> ResponseEntity<Object> created(T createdEntity, boolean addIdPath) {

        // Create resource location
        ServletUriComponentsBuilder uriComponentsBuilder = ServletUriComponentsBuilder.fromCurrentRequest();
        URI location;
        if (addIdPath) {
            location = uriComponentsBuilder.path("/{id}")
                    .buildAndExpand(createdEntity.getId()).toUri();
        } else {
            location = uriComponentsBuilder.build().toUri();
        }
        //Send location in response
        return ResponseEntity.created(location).body(createdEntity);
    }
}
