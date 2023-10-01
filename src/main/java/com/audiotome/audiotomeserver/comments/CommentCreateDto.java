package com.audiotome.audiotomeserver.comments;

import lombok.Data;

@Data
public class CommentCreateDto {
    private String commentContent;
    private int userId;
    private int a_id;
    private int c_likes;
}
