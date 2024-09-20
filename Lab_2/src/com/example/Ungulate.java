package com.example;

import java.util.ArrayList;
import java.util.List;

// Model
class Ungulate extends Animal {
    public Ungulate(double weight, int age) {
        super(weight, age);
    }

    @Override
    public void move(Enclosure enclosure) {
        if (enclosure instanceof OpenEnclosure) {
            System.out.println("Копытное животное перемещено в открытый вольер");
        } else {
            throw new IllegalArgumentException("Копытное животное может быть помещено только в открытый вольер");
        }
    }
}

