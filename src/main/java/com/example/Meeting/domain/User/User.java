package com.example.Meeting.domain.User;

import com.example.Meeting.domain.Image.Image;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    String username;
    String password;
    String email;

    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY)
    private Image profileImage;

    @Column(nullable = false)
    String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;
}
