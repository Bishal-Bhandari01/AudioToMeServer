package com.audiotome.audiotomeserver.auth;

import com.audiotome.audiotomeserver.role.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String password;
    private String dob;
    private String registeredDate;
    private Role role;

}
