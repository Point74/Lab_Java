package com.example;

import java.util.ArrayList;
import java.util.List;

class Aquatic extends Animal {
    public Aquatic(double weight, int age) {
        super(weight, age);
    }

    @Override
    public void move(Enclosure enclosure) {
        if (enclosure instanceof Aquarium) {
            System.out.println("Водоплавающее животное перемещено в аквариум");
        } else {
            throw new IllegalArgumentException("Водоплавающее животное может быть помещено только в аквариум");
        }
    }
}

