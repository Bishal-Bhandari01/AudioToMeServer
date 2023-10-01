package com.audiotome.audiotomeserver.comments;

import lombok.Data;

@Data
public class CommentUpdateDto extends CommentCreateDto {
    private Long c_id;
}
