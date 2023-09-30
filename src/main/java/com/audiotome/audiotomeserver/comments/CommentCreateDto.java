package com.audiotome.audiotomeserver.comments;

<<<<<<< HEAD
import com.audiotome.audiotomeserver.user.User;
=======
>>>>>>> 17faaac ( new server hosting)
import lombok.Data;

@Data
public class CommentCreateDto {
    private String commentContent;
    private int userId;
    private int a_id;
    private int c_likes;
}
