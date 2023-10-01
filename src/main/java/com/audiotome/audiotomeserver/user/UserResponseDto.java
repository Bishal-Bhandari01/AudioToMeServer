package com.audiotome.audiotomeserver.user;

import com.audiotome.audiotomeserver.bookmarked.BookMark;
import com.audiotome.audiotomeserver.comments.Comments;
import com.audiotome.audiotomeserver.role.Role;
import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
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
    private String registerDate;
    private String lastLoginDate;
}
