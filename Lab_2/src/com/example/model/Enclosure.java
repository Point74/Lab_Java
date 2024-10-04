package com.example.model;

import java.util.ArrayList;
import java.util.List;

// Model

/**
 * Абстрактный класс, представляющий вольер в зоопарке.
 */

public abstract class Enclosure {
    private int capacity;
    private List<Animal> animals;

    /**
     * Конструктор для создания нового вольера.
     *
     * @param capacity вместимость вольера
     */

    public Enclosure(int capacity) {
        this.capacity = capacity;
        this.animals = new ArrayList<>();
    }

    /**
     * Добавляет животное в вольер.
     *
     * @param animal животное для добавления
     * @throws IllegalStateException если вольер уже заполнен
     */

    public void addAnimal(Animal animal) {
        if (animals.size() < capacity) {
            animals.add(animal);
        } else {
            throw new IllegalStateException("Вольер полон");
        }
    }

    // Геттеры и сеттеры
}
