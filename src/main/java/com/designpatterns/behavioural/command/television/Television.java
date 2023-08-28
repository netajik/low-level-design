package com.designpatterns.behavioural.command.television;

/**
 * Receiver/consumer
 */
class Television {
    public void on() {
        System.out.println("Television on");
    }

    public void off() {
        System.out.println("Television off");
    }
}