package com.endos.book.auth;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {


    private String accessToken;
    private String refreshToken;
}
