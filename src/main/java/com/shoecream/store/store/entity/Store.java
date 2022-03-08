package com.shoecream.store.store.entity;

import com.shoecream.store.global.BaseTimeEntity;
import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Getter
@Entity
public class Store extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "chat_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "chatroom_user_id")
    private ChatroomUser chatroomUser;

    private String content;
}
