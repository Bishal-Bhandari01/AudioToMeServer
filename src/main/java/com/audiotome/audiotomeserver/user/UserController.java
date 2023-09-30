package com.audiotome.audiotomeserver.user;
<<<<<<< HEAD

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

>>>>>>> 17faaac ( new server hosting)
@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

//    private final FileUploadService fileUploadService;

<<<<<<< HEAD

    @PostMapping("/addUser")
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserResponseDto SaveUser(@RequestBody UserCreateDto request) {
        return userService.saveUser(request);
=======
    @PostMapping("/saveUser")
    public ResponseEntity<UserResponseDto> register(
            @RequestBody UserCreateDto request
    ) {
        return ResponseEntity.ok(userService.saveUser(request));
>>>>>>> 17faaac ( new server hosting)
    }

    @GetMapping("/getUser")
    @ResponseStatus(code = HttpStatus.OK)
    public UserListResponseDto GetAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUserById")
    @ResponseStatus(code = HttpStatus.OK)
    public UserResponseDto GetUserByID(@RequestParam("id") Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/getUserByEmail")
    @ResponseStatus(code = HttpStatus.OK)
    public UserResponseDto GetUserByEmail(@RequestParam("email") String email) {
        return userService.getUserByEmail(email);
    }

    @PutMapping("/updateGeneralProfile")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public UserResponseDto UpdateUserProfile(@RequestParam("id") Long id, @RequestBody UserUpdateDto request) {
        return userService.updateUserProfile(id, request);
    }

    @PutMapping("/updateGeneralContact")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public UserResponseDto UpdateUserContact(@RequestParam("id") Long id, @RequestBody UserUpdateDto request) {
        return userService.updateUserContact(id, request);
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.DELETE)
    public void DeleteUserById(@RequestParam("id") Long id) {
        userService.deleteById(id);
    }
}
