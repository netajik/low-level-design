package com.lld.snakeandladder.model;

import lombok.Getter;

@Getter
public class Snake {
    private Integer start;
    private Integer end;

    public Snake(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }
}
