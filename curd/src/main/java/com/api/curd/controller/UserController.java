package com.api.curd.controller;

import com.api.curd.dto.UserDto;
import com.api.curd.entity.User;
import com.api.curd.exceptions.ErrorDetails;
import com.api.curd.exceptions.ResourceNotFountException;
import com.api.curd.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;


@Tag(
        name = "Curd API for manage users",
        description = "Create, get, get all, update, delete APIs"
)
@RestController
@AllArgsConstructor
@RequestMapping("users")
public class UserController {
    //http://localhost:8080/actuator/info
    //http://localhost:8080/actuator/shutdown
    //http://localhost:8080/swagger-ui/index.htm
    private UserService userService;

    //We can return user object direct but in that scenario we can't control
    // response status, header, body etc so we use ResponseEntity
    //    @PostMapping()
    //    public User createUser(@RequestBody User user){
    //        User savedUser = userService.createUser(user);
    //        return savedUser;
    //    }



    // Instead of jpa we can use DTO for more security and
    // we also have the control which information to send and received
    // This is actually object wrapper
    //    @PostMapping()
    //    public ResponseEntity<User> createUser(@RequestBody User user){
    //        User savedUser = userService.createUser(user);
    //        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    //    }
    // Build create user REST API
    // http://localhost:8080/users
    @Operation(
            summary = "Create user rest API",
            description = "This API create user"
    )
    @PostMapping()
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //http://localhost/users/1
    @Operation(
            summary = "Get user rest API",
            description = "This API get one user"
    )
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto userDto = userService.getUserById(userId);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    //http://localhost:8080/users/all
    @Operation(
            summary = "Get users rest API",
            description = "This API all user"
    )
    @GetMapping("all")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //http://localhost:8080/users/{id}
    @Operation(
            summary = "Update user rest API",
            description = "This API update user"
    )
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userID, @Valid @RequestBody UserDto userDto){
        userDto.setId(userID);
        UserDto updatedUser = userService.updateUser(userDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete user rest API",
            description = "This API delete a user by ID"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User delete successfully",HttpStatus.OK);
    }

}
