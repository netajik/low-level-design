package com.design.patterns.creational.factory.pizzasimplefactory;

public class ChickenPizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("preparing ChickenPizza pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking ChickenPizza pizza");
    }

    @Override
    public void cut() {
        System.out.println("cutting ChickenPizza pizza");
    }
}
