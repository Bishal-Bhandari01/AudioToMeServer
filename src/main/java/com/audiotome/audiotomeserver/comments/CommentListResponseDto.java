package com.audiotome.audiotomeserver.comments;

import lombok.Data;

import java.util.List;

@Data
public class CommentListResponseDto {
    private List<CommentResponseDto> responseDtoList;
    private int total;
}
