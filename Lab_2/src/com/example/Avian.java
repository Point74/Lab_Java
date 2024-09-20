package com.example;

import java.util.ArrayList;
import java.util.List;

// Model
class Avian extends Animal {
    public Avian(double weight, int age) {
        super(weight, age);
    }

    @Override
    public void move(Enclosure enclosure) {
        if (enclosure instanceof NettedEnclosure) {
            System.out.println("Пернатое животное перемещено в вольер с сеткой");
        } else {
            throw new IllegalArgumentException("Пернатое животное может быть помещено только в вольер с сеткой");
        }
    }
}