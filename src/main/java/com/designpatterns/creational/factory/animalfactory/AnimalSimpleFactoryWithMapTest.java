package com.design.patterns.creational.factory.animalfactory;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

class AnimalSimpleFactoryWithMap {
    private static final Map<String, Class<? extends Animal>> animalMap = new HashMap<>();

    static {
        animalMap.put("dog",DogAnimal.class);
        animalMap.put("cat", CatAnimal.class);
        animalMap.put("cow", CowAnimal.class);
    }

    public static Animal createAnimal(String animalType) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<? extends Animal> animal = animalMap.get(animalType);
        if(animal == null){
            throw new IllegalArgumentException("Invalid animal type: "+animalType);
        }
        return animal.getDeclaredConstructor().newInstance();
    }
}

public class AnimalSimpleFactoryWithMapTest {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Animal animal = AnimalSimpleFactoryWithMap.createAnimal("dog");
        System.out.println(animal.getSound());
    }
}
