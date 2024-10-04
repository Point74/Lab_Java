package com.example.model;

import com.example.model.Enclosure;

/**
 * Класс, представляющий водоплавающее животное.
 */

public class Aquatic extends Animal {

    /**
     * Конструктор для создания нового водоплавающего животного.
     *
     * @param weight вес животного
     * @param age возраст животного
     */

    public Aquatic(double weight, int age) {
        super(weight, age);
    }

    /**
     * Перемещает водоплавающее животное в аквариум.
     *
     * @param enclosure вольер, в который перемещается животное
     * @throws IllegalArgumentException если вольер не является аквариумом
     */

    @Override
    public void move(Enclosure enclosure) {
        if (enclosure instanceof Aquarium) {
            System.out.println("Водоплавающее животное перемещено в аквариум");
        } else {
            throw new IllegalArgumentException("Водоплавающее животное может быть помещено только в аквариум");
        }
    }
}

