package com.audiotome.audiotomeserver.user;

import com.audiotome.audiotomeserver.constant.DateTime;
import com.audiotome.audiotomeserver.role.Role;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.*;
import java.time.LocalDate;

@Service
public class UserService {
    private PasswordEncoder passwordEncoder;

//    private final FileUploadService fileUploadService;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private ModelMapper modelMapper;

    public UserService() {
    }

    public LocalDate GetToDayDate() {
        LocalDate myObj = LocalDate.now(); // Create a date objec
        return myObj;
    }

    public UserResponseDto saveUser(UserCreateDto request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .middleName(request.getMiddleName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(HashedPassword(request.getPassword()))
                .registrationDate(GetToDayDate())
                .dob(request.getDob())
                .role(Role.USER)
                .build();
        User users = userRepo.save(user);
        return getUserResponse(users);
    }

    private UserResponseDto getUserResponse(User request) {
        UserResponseDto resp = new UserResponseDto();
        resp.setId(request.getId());
        resp.setFirstName(request.getFirstName());
        resp.setLastName(request.getLastName());
        resp.setEmail(request.getEmail());
        return resp;
    }

    private UserResponseDto getUserResponseDto(User savedUser) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(savedUser.getId());
        responseDto.setFirstName(savedUser.getFirstName());
        responseDto.setLastName(savedUser.getLastName());
        responseDto.setMiddleName(savedUser.getMiddleName());
        responseDto.setEmail(savedUser.getEmail());
        responseDto.setDob(savedUser.getDob());
        responseDto.setPassword(savedUser.getPassword());
        responseDto.setAddress(savedUser.getAddress());
        responseDto.setContactNum(savedUser.getContactNum());
        responseDto.setRole(savedUser.getRole());
        responseDto.setRegisterDate(savedUser.getRegistrationDate());
        responseDto.setUProfile(savedUser.getUProfile());

        return responseDto;
    }

    public UserListResponseDto getAllUsers() {
        List<UserResponseDto> userResponse = new ArrayList<>();
        List<User> user = (List<User>) userRepo.findAll();
        for (User users : user) {
            userResponse.add(getUserResponseDto(users));
        }
        UserListResponseDto response = new UserListResponseDto();
        response.setResponse(userResponse);
        response.setTotal(userResponse.size());
        return response;
    }

    public UserResponseDto getUserById(Long id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            return getUserResponseDto(user.get());
        }
        return null;
    }

    public UserResponseDto updateUserProfile(Long id, UserUpdateDto request) {
        Optional<User> optUser = userRepo.findById(id);
        if (optUser.isPresent()) {
            User user = optUser.get();
            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());
            user.setMiddleName(request.getMiddleName());
            user.setDob(request.getDob());
            user.setAddress(request.getAddress());
            user.setUProfile(request.getUProfile());

            User users = userRepo.save(user);
            return getUserResponseDto(users);
        }
        return null;
    }

    public String HashedPassword(@NonNull String passwd) {
        passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(passwd);
        return hashedPassword;
    }

    public boolean TestPassword(String pword, String requestedPwd) {
        boolean check = false;
        this.passwordEncoder = new BCryptPasswordEncoder();
        if (this.passwordEncoder.matches(pword, requestedPwd)) {
            check = true;
        }
        return check;
    }

    public UserResponseDto getUserByEmail(String email) {
        Optional<User> optUser = userRepo.findByEmail(email);
        if (optUser.isPresent()) {
            return getUserResponseDto(optUser.get());
        }
        return null;
    }

    public UserResponseDto updateUserContact(Long id, UserUpdateDto request) {
        Optional<User> optUser = userRepo.findById(id);
        if (optUser.isPresent()) {
            User user = optUser.get();
            user.setContactNum(request.getContactNum());
            user.setEmail(request.getEmail());

            User users = userRepo.save(user);
            return getUserResponseDto(users);
        }
        return null;
    }
    @Transactional
    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }

    public DateTime getUserBasedOnTime() {

        LocalDate today = LocalDate.now();
        List<User> user = userRepo.findByRegistrationDate(today);

        LocalDate currentMonthDate = LocalDate.now();
        LocalDate startOfMonth = currentMonthDate.withDayOfMonth(1);
        LocalDate endOfMonth = currentMonthDate.withDayOfMonth(currentMonthDate.lengthOfMonth());
        List<User> monthlyuser = userRepo.findByRegistrationDateBetween(startOfMonth,endOfMonth);

        LocalDate currentYearDate = LocalDate.now();
        LocalDate startOfYear = currentYearDate.withDayOfYear(1);
        LocalDate endOfYear = currentYearDate.withDayOfYear(currentYearDate.lengthOfYear());
        List<User> yearlyuser = userRepo.findByRegistrationDateBetween(startOfYear, endOfYear);

        LocalDate weekly = LocalDate.now();
        LocalDate startDate = weekly;
        LocalDate endDate = weekly;

        // Find the start date (Monday) of the week
        while (startDate.getDayOfWeek() != DayOfWeek.SUNDAY) {
            startDate = startDate.minusDays(1);
        }

        // Find the end date (Sunday) of the week
        while (endDate.getDayOfWeek() != DayOfWeek.SATURDAY) {
            endDate = endDate.plusDays(1);
        }
        List<User> weeklyUsers = userRepo.findByRegistrationDateBetween(startDate, endDate);

        List<User> users = userRepo.findAll();

        var dateTime = DateTime.builder()
                .daily(user.size())
                .monthly(monthlyuser.size())
                .weekly(weeklyUsers.size())
                .yearly(yearlyuser.size())
                .totally(users.size())
                .build();

        return dateTime;
    }

}