package com.lld.snakeandladder.model;

import lombok.Getter;

@Getter
public class Ladder {
    private Integer start;
    private Integer end;

    public Ladder(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

}
