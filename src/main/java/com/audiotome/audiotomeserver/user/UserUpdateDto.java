package com.audiotome.audiotomeserver.user;

import lombok.Data;

@Data
public class UserUpdateDto extends UserCreateDto {
    private Long id;
}
