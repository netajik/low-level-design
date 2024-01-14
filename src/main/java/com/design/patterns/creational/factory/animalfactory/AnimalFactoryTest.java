package com.design.patterns.creational.factory.animalfactory;

abstract class AnimalFactory {
    abstract Animal createAnimal();
}

class DogFactory extends AnimalFactory {

    @Override
    Animal createAnimal() {
        return new DogAnimal();
    }
}

class CatFactory extends AnimalFactory {

    @Override
    Animal createAnimal() {
        return new CatAnimal();
    }
}

class CowFactory extends AnimalFactory {

    @Override
    Animal createAnimal() {
        return new CowAnimal();
    }
}

public class AnimalFactoryTest {
    public static void main(String[] args) {
        AnimalFactory animalFactory = new DogFactory();
        Animal animal = animalFactory.createAnimal();
        System.out.println(animal.getSound());
    }
}
