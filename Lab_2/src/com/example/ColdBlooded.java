package com.example;

import java.util.ArrayList;
import java.util.List;

// Model
class ColdBlooded extends Animal {
    public ColdBlooded(double weight, int age) {
        super(weight, age);
    }

    @Override
    public void move(Enclosure enclosure) {
        if (enclosure instanceof InfraredEnclosure) {
            System.out.println("Хладнокровное животное перемещено в вольер с инфракрасным освещением");
        } else {
            throw new IllegalArgumentException("Хладнокровное животное может быть помещено только в вольер с инфракрасным освещением");
        }
    }
}
