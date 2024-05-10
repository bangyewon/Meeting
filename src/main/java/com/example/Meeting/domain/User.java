package com.example.Meeting.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    String username;
    String password;
    String email;

    @Column(nullable = true)
    String profileImage;

    @Column(nullable = false)
    String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;
}
