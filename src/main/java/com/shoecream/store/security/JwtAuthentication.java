package com.shoecream.store.security;

public class JwtAuthentication {

    public final Long id;

    public final String name;

    JwtAuthentication(Long id, String name) {

        this.id = id;
        this.name = name;
    }

}