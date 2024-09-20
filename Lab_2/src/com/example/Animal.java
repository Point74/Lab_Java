package com.example;

import java.util.ArrayList;
import java.util.List;

abstract class Animal {
    private double weight;
    private int age;

    public Animal(double weight, int age) {
        this.weight = weight;
        this.age = age;
    }

    public abstract void move(Enclosure enclosure);

    // Геттеры и сеттеры
}