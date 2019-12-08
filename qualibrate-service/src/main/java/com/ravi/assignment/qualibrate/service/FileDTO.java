package com.ravi.assignment.qualibrate.service;

import com.ravi.assignment.qualibrate.domain.IdAware;

import java.util.UUID;

public class FileDTO implements IdAware {

    private Long id;

    private UUID uuid;

    private String name;

    private String path;

    private String mime;

    @Override
    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public UUID getUuid() {

        return uuid;
    }

    public void setUuid(UUID uuid) {

        this.uuid = uuid;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getPath() {

        return path;
    }

    public void setPath(String path) {

        this.path = path;
    }

    public String getMime() {

        return mime;
    }

    public void setMime(String mime) {

        this.mime = mime;
    }
}
