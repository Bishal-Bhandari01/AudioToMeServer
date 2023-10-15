package com.audiotome.audiotomeserver.auth;

import com.audiotome.audiotomeserver.config.JwtService;
import com.audiotome.audiotomeserver.user.User;
import com.audiotome.audiotomeserver.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins="*")
@RequiredArgsConstructor
public class AuthController {

    private final UserDetailsService userDetailsService;

    private final AuthenticationManager authmanager;

    private final JwtService jwtHelper;

    private final PasswordEncoder passencoder;

    @Autowired
    private UserRepository userRepo;

    private final JavaMailSender emailSender;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request){
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passencoder.encode(request.getPassword()))
                .dob((request.getDob()))
                .registrationDate(LocalDate.now())
                .role(request.getRole())
                .build();
        userRepo.save(user);
        return new ResponseEntity<>("User created successfully!", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request){

        this.doAuthenticate(request.getEmail(),request.getPassword());

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        Optional<User> optUser = userRepo.findByEmail(request.getEmail());
        String token = jwtHelper.generateToken(userDetails);

        JwtResponse response = JwtResponse.builder()
                .jwt(token)
                .message("Login successfully!")
                .user(optUser.get())
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(
            String email,
            String password
    ) throws BadCredentialsException {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                email,
                password
        );
        authmanager.authenticate(authToken);
    }

    @RequestMapping(value="/resetPassword", method = RequestMethod.POST)
    public String SetResetPassword(@RequestParam("email") String email){
        User users = userRepo.findByEmail(email).orElse(null);
        if(users != null){
           String randomPassword = generateRandomPassword();
           String hashedPassword = passencoder.encode(randomPassword);
           users.setPassword(hashedPassword);
           userRepo.save(users);
           SendPaswordToEmail(email,randomPassword);
        }
        else{
            return "User not found";
        }
        return "Password has been reset!!";
    }

    private void SendPaswordToEmail(String email, String randomPassword) {
        SimpleMailMessage sendMessage = new SimpleMailMessage();
        sendMessage.setTo(email);
        sendMessage.setSubject("Password recovery link");
        sendMessage.setText("<html><body><h1>Password Recovered!!</h1><p>Kindly requested you to change the password after you have successfully logedin!</p><p>Your email: " + email +"</p><br><p>Your password: " + randomPassword + "</p><br></body></html>");
        emailSender.send(sendMessage);
    }

    private String generateRandomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        int passwordLength = 12;

        for (int i=0; i < passwordLength; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }
        return password.toString();
    }
}
