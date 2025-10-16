package spring.userapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spring.userapp.dto.CreateUserRequest;
import spring.userapp.dto.UpdateUserRequest;
import spring.userapp.dto.UserResponse;
import spring.userapp.dto.WebResponse;
import spring.userapp.service.UserService;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(
            path = "/api/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> create(@RequestBody CreateUserRequest request){
        userService.createUser(request);

        return WebResponse.<String>builder().data("User created successfully").build();
    }

    @GetMapping(
            path = "/api/users",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<UserResponse>> get(){
        List<UserResponse> response = userService.getUser();

        return WebResponse.<List<UserResponse>>builder().data(response).build();
    }

    @GetMapping(
            path = "/api/users/{userId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<UserResponse> getById(@PathVariable("userId") String userId){
        UserResponse response = userService.getUserById(userId);

        return WebResponse.<UserResponse>builder().data(response).build();
    }

    @PatchMapping(
            path = "/api/users/{userId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<UserResponse> update(@PathVariable("userId") String userId, @RequestBody UpdateUserRequest request){
        UserResponse userResponse = userService.updateUser(userId, request);

        return WebResponse.<UserResponse>builder().data(userResponse).build();
    }

    @DeleteMapping(
            path = "/api/users/{userId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> deleteUser(@PathVariable("userId") String userId){
        userService.deleteUser(userId);

        return WebResponse.<String>builder().data("User deleted successfully").build();
    }
}
