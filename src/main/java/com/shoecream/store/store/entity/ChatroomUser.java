package com.shoecream.store.store.entity;

import com.shoecream.store.global.BaseTimeEntity;
import com.shoecream.store.user.entity.User;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Getter
@Entity
public class ChatroomUser extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "chatroom_user_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "chatroom_id")
    private ChatRoom chatRoom;

    @OneToMany(mappedBy = "chatroomUser")
    private List<Store> store = new ArrayList<>();


}
