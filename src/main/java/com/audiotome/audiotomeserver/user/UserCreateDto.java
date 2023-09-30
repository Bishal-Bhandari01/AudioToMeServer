package com.audiotome.audiotomeserver.user;

<<<<<<< HEAD
=======
import com.audiotome.audiotomeserver.role.Role;
>>>>>>> 17faaac ( new server hosting)
import lombok.Data;

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
<<<<<<< HEAD
    private UserEnum role;
=======
    private Role role;
>>>>>>> 17faaac ( new server hosting)
    private String registerDate;
    private String lastLoginDate;

}
