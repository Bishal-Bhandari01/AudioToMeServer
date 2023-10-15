package com.audiotome.audiotomeserver.user;
import com.audiotome.audiotomeserver.cloudinary.FileUploadResponse;
import com.audiotome.audiotomeserver.cloudinary.FileUploadService;
import com.audiotome.audiotomeserver.constant.DateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    private final FileUploadService fileUpload;

    @PostMapping("/saveUser")
    public ResponseEntity<UserResponseDto> register(
            @RequestBody UserCreateDto request
    ) {
        return ResponseEntity.ok(userService.saveUser(request));
    }

    @RequestMapping(value="/profileUpdate", method = RequestMethod.POST)
    public ResponseEntity<FileUploadResponse> SaveFileCloud(@RequestPart("image") MultipartFile file) throws IOException {
        return ResponseEntity.ok(fileUpload.uploadFile(file));
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

    @RequestMapping(value = "/getUserBasedOnTime", method = RequestMethod.POST)
    public DateTime getUserBasedOnTime(){
        return userService.getUserBasedOnTime();
    }
}
