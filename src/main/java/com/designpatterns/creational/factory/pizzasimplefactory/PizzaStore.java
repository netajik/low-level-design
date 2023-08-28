package com.designpatterns.creational.factory.pizzasimplefactory;

public class PizzaStore {

    public Pizza orderPizza(String type) {

        Pizza p = PizzaFactory.createPizza(type);
        p.prepare();
        p.bake();
        p.cut();

        return p;
    }
}
