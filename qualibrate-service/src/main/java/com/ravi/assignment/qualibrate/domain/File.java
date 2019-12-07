package com.ravi.assignment.qualibrate.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "files")
public class File implements IdAware {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "uuid", nullable = false, length = 36)
    private UUID uuid;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "path", nullable = false, length = 200)
    private String path;

    @Column(name = "mime", nullable = false, length = 30)
    private String mime;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
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
