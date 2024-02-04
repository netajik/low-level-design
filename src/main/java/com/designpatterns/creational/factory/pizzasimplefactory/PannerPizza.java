package com.design.patterns.creational.factory.pizzasimplefactory;

public class PannerPizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("preparing panner pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking panner pizza");
    }

    @Override
    public void cut() {
        System.out.println("cutting panner pizza");
    }
}
