package com.audiotome.audiotomeserver.user;

import com.audiotome.audiotomeserver.bookmarked.BookMark;
import com.audiotome.audiotomeserver.comments.Comments;
<<<<<<< HEAD
import lombok.Data;

import java.util.List;
=======
import com.audiotome.audiotomeserver.role.Role;
import lombok.Data;

import java.util.List;

>>>>>>> 17faaac ( new server hosting)
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
<<<<<<< HEAD
    private UserEnum role;
    private String registerDate;
    private String lastLoginDate;

    private List<BookMark> bookMarkList;

    private List<Comments> commentsList;
=======
    private Role role;
    private String registerDate;
    private String lastLoginDate;
>>>>>>> 17faaac ( new server hosting)
}
