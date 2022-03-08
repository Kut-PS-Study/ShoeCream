package com.shoecream.store.user.entity;

import com.shoecream.store.global.BaseTimeEntity;
import com.shoecream.store.store.entity.ChatroomUser;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "user")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    private String username;

    private String password;

    @OneToMany(mappedBy = "owner")
    private List<Friend> friend = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<ChatroomUser> chatroomUsers = new ArrayList<>();


    public void login(PasswordEncoder passwordEncoder, String credentials) {
        if (!passwordEncoder.matches(credentials, password)) {
            throw new IllegalArgumentException("Bad credential");
        }
    }
}