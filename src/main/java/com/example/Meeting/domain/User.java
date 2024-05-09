package com.example.Meeting.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    String username;
    String passward;
    String email;

    @Column(nullable = true)
    String profileImage;

    @Column(nullable = false)
    String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;
}
