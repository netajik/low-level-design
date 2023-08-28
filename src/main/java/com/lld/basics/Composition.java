package com.lld.basics;

class Engine {
    public void start(){
        System.out.println("Engine started..!");
    }

    public void stop(){

    }
}

class Car {
    void carStart(){
        Engine engine = new Engine();
        engine.start();
    }
}

public class Composition {
    public static void main(String args[]){
        Car car = new Car();
        car.carStart();

    }
}
