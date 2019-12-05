package com.ravi.assignment.qualibrate.domain;

import java.util.UUID;

public class File {

    private String name;

    private String path;

    private String mime;

    private UUID uuid;

    private User user;

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

    public UUID getUuid() {

        return uuid;
    }

    public void setUuid(UUID uuid) {

        this.uuid = uuid;
    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {

        this.user = user;
    }
}
