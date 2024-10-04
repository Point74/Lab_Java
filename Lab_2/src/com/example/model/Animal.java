package com.example.model;
import com.example.model.Enclosure;

/**
 * Абстрактный класс, представляющий животное в зоопарке.
 */

public abstract class Animal {
    private double weight;
    private int age;

    /**
     * Конструктор для создания нового животного.
     *
     * @param weight вес животного
     * @param age возраст животного
     */

    public Animal(double weight, int age) {
        this.weight = weight;
        this.age = age;
    }

    /**
     * Абстрактный метод для перемещения животного в вольер.
     *
     * @param enclosure вольер, в который перемещается животное
     */

    public abstract void move(Enclosure enclosure);

    // Геттеры и сеттеры
}