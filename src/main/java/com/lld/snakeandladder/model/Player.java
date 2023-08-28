package com.lld.snakeandladder.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Player {
    private String id;
    private String name;

    public Player(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }
}
