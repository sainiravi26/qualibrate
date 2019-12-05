package com.ravi.assignment.qualibrate.api;

import static com.ravi.assignment.qualibrate.api.ResponseEntityBuilder.created;

import com.ravi.assignment.qualibrate.service.UserDTO;
import com.ravi.assignment.qualibrate.service.UserService;

import javax.validation.Valid;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(path = "/users")
public class UserApis {

    private final UserService userService;

    UserApis(UserService userService) {

        this.userService = userService;
    }

    @Operation(summary = "Creates a new user", description = "It uses the email as a primarily identifier of the user "
            + "and as credentials to authenticate in the platform.", tags = { "users" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User is successfully created", headers = {
                    @Header(name = "location", description = "Location of created user resource") }) })
    @PostMapping(consumes = { "application/json" })
    public ResponseEntity<Object> createUser(@Valid UserDTO user) {

        try {
            userService.createUser(user);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
        }
        return created(user);
    }

    @Operation(summary = "Fetch a user by its identifier", description = "User is assigned a unique identity when it  is created."
            , tags = { "users" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns user matching to the id"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {

        userService.getUser(id);
        return null;
    }

    @Operation(summary = "List all users", description = "Returns a collection of users paginated and consolidated"
            + "        in bundles of 10 (by default) per page", tags = { "users" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users list")
    })
    @GetMapping(params = { "page", "pageSize" })
    public Page<UserDTO> getUsers(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {

        return userService.findUsers(PageRequest.of(page, pageSize));
    }

    @Operation(summary = "Deletes an existing user", description = " Removes in cascade all information associated to "
            + "an individual user.", tags = { "users" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "User successfully deleted"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "400", description = "Integrity violation")
    })
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {

        userService.getUser(id);
        return null;
    }

    @Operation(summary = "Creates a new user", description = "It uses the email as a primarily identifier of the user "
            + "and as credentials to authenticate in the platform.", tags = { "users" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User is successfully created", headers = {
                    @Header(name = "location", description = "Location of created user resource") }) })
    @PutMapping(path = "/{id}", consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity<Object> createOrUpdateUser(UserDTO user) {

        try {
            userService.createUser(user);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
        }
        return created(user);
    }
}
