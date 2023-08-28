package com.lld.snakeandladder.service;

import java.util.Random;

public class DiceService {

    public static Integer roll() {
        return new Random().nextInt(6)+1;
    }
}
