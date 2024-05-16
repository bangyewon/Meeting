package com.example.Meeting.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "user")
@Builder
@Getter
@Setter
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

    @Column
    String profileImage;

    @Column(nullable = false)
    String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;
}
