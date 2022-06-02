package com.example.regiapp.registration.token;

import com.example.regiapp.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class ConfirmationToken {
    @Id
    @GeneratedValue(
            strategy = GenerationType.TABLE
    )
    private Long id;
   @Column(nullable = false, name = "token")
    private String token;
    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;
    @Column(nullable = false, name = "expired_at")
    private LocalDateTime expiredAt;
    @Column(name = "confirmed_at")
    private LocalDateTime confirmedAt;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "user_id"
    )
    private User user;


    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiredAt,  User user) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
        this.user=user;
    }
}
