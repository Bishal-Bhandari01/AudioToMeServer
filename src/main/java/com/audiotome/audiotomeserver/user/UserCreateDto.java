package com.audiotome.audiotomeserver.user;

import com.audiotome.audiotomeserver.role.Role;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserCreateDto {

    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String dob;
    private String password;
    private String address;
    private String contactNum;
    private String uProfile;
    private Role role;
    private LocalDate registerDate;

}
