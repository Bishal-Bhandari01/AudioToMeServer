package com.audiotome.audiotomeserver.auth;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {

    private String jwt;
    private String message;

}
