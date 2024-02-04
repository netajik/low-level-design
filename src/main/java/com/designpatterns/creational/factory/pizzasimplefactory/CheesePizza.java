package com.design.patterns.creational.factory.pizzasimplefactory;

public class CheesePizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("preparing cheese pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking cheese pizza");
    }

    @Override
    public void cut() {
        System.out.println("cutting cheese pizza");
    }
}
