package com.shoecream.store.user.entity;

import com.sidepr.chat.global.BaseTimeEntity;
import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Getter
@Entity
public class Friend extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn
    private User owner;

    @ManyToOne(fetch = LAZY)
    @JoinColumn
    private User friend;

}
