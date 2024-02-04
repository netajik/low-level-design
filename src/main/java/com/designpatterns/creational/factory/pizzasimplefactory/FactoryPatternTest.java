package com.design.patterns.creational.factory.pizzasimplefactory;

public class FactoryPatternTest {

    public static void main(String[] args) {
        PizzaStore pizzaStore = new PizzaStore();
        pizzaStore.orderPizza("cheese");
    }
}
