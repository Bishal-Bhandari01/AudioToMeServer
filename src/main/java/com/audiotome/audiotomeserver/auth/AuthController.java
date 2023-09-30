package com.audiotome.audiotomeserver.auth;

import com.audiotome.audiotomeserver.config.JwtHelper;
import com.audiotome.audiotomeserver.user.User;
import com.audiotome.audiotomeserver.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authmanager;

    @Autowired
    private JwtHelper jwtHelper;

    private final PasswordEncoder passencoder;

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request){
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passencoder.encode(request.getPassword()))
                .dob((request.getDob()))
                .registrationDate(String.valueOf(new Date()))
                .role(request.getRole())
                .build();
        userRepo.save(user);
        return new ResponseEntity<>("User created successfully!", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request){

        this.doAuthenticate(request.getEmail(),request.getPassword());

        System.out.println("request: " + request);

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = jwtHelper.generateToken(userDetails);
        JwtResponse response = JwtResponse.builder()
                .jwt(token)
                .message("Login successfully!")
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) throws BadCredentialsException {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                email,password
        );
        authmanager.authenticate(authToken);
    }
}
