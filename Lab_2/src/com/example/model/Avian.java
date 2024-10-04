package com.example.model;

import com.example.model.Enclosure;
import com.example.model.NettedEnclosure;

// Model

/**
 * Класс, представляющий пернатое животное.
 */


public class Avian extends Animal {

    /**
     * Конструктор для создания нового пернатого животного.
     *
     * @param weight вес животного
     * @param age возраст животного
     */

    public Avian(double weight, int age) {
        super(weight, age);
    }

    /**
     * Перемещает пернатое животное в вольер с сеткой.
     *
     * @param enclosure вольер, в который перемещается животное
     * @throws IllegalArgumentException если вольер не с сеткой
     */

    @Override
    public void move(Enclosure enclosure) {
        if (enclosure instanceof NettedEnclosure) {
            System.out.println("Пернатое животное перемещено в вольер с сеткой");
        } else {
            throw new IllegalArgumentException("Пернатое животное может быть помещено только в вольер с сеткой");
        }
    }
}