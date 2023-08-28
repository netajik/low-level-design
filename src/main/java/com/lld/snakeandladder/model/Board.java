package com.lld.snakeandladder.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Board {

    private List<Snake> snakes;
    private List<Ladder> ladders;
    private Map<String, Integer> playerPieces;
    private Integer size;

    public Board(Integer size) {
        this.size = size;
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
        this.playerPieces = new HashMap<>();
    }
}
