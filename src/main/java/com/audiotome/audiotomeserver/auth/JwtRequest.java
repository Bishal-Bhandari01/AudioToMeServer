package com.audiotome.audiotomeserver.auth;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest {

    private String email;
    private String password;

}
