package com.example;

import java.util.ArrayList;
import java.util.List;

// Model
abstract class Enclosure {
    private int capacity;
    private List<Animal> animals;

    public Enclosure(int capacity) {
        this.capacity = capacity;
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        if (animals.size() < capacity) {
            animals.add(animal);
        } else {
            throw new IllegalStateException("Вольер полон");
        }
    }

    // Геттеры и сеттеры
}
