package com.endos.book.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Token {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String token;
    @Column(unique = true)
    private String refreshToken;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
    private LocalDateTime refreshExpiresAt; // Masa kedaluwarsa untuk refresh token
    private LocalDateTime validatedAt;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    private boolean revoked; // Untuk menandakan apakah token ini sudah dicabut
    private boolean expired; // Untuk menandakan apakah token ini sudah kadaluwarsa



}
