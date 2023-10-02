package com.audiotome.audiotomeserver.auth;

import com.audiotome.audiotomeserver.user.User;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {

    private String jwt;
    private String message;

    private User user;

}
