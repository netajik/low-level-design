package com.designpatterns.creational.factory.animalfactory;

interface Animal {
    String getSound();
}

class DogAnimal implements Animal {

    @Override
    public String getSound() {
        return "Woof!";
    }
}

class CatAnimal implements Animal {

    @Override
    public String getSound() {
        return "Meow!";
    }
}

class CowAnimal implements Animal {

    @Override
    public String getSound() {
        return "Moo!";
    }
}

class AnimalSimpleFactory {
    Animal createAnimal(String type) {
        switch (type.toLowerCase()){
            case "dog":
                return new DogAnimal();
            case "cat":
                return new CatAnimal();
            case "cow":
                return new CowAnimal();
            default:
                throw new IllegalArgumentException("Invalid animal type: "+type);
        }
    }
}

public class AnimalSimpleFactoryTest {
    public static void main(String[] args) {
        AnimalSimpleFactory animalSimpleFactory = new AnimalSimpleFactory();
        Animal animal = animalSimpleFactory.createAnimal("dog");
        System.out.println(animal.getSound());
    }
}
