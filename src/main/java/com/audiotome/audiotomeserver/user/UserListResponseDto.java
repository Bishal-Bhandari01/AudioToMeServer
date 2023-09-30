package com.audiotome.audiotomeserver.user;

import lombok.Data;

import java.util.List;

@Data
public class UserListResponseDto {
    private List<UserResponseDto> response;
    private int total;
}
