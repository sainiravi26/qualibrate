package com.ravi.assignment.qualibrate.service;

import com.ravi.assignment.qualibrate.domain.IdAware;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import io.swagger.v3.oas.annotations.media.Schema;

public class UserDTO implements IdAware {

    @Schema(description = "Unique identifier",
            example = "1", required = false)
    private Long id;

    @Schema(description = "First name of user",
            example = "John", required = true)
    @Pattern(regexp = "^[A-Za-z]*")
    private String firstName;

    @Schema(description = "Last name of user",
            example = "Smith", required = true)
    @Pattern(regexp = "^[A-Za-z]*")
    @NotBlank
    private String lastName;

    @Schema(description = "Contact email",
            example = "jsmith@gmail.com", required = true)
    @Pattern(regexp = "[^@]+@[^@]+\\.[^@]+")
    @NotBlank
    private String email;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }
}
