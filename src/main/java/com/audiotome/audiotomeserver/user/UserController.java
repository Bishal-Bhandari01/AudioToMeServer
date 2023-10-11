package com.audiotome.audiotomeserver.user;
import com.audiotome.audiotomeserver.constant.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<UserResponseDto> register(
            @RequestBody UserCreateDto request
    ) {
        return ResponseEntity.ok(userService.saveUser(request));
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
