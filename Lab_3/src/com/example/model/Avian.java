package com.example.model;

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
     * @return
     * @throws IllegalArgumentException если вольер не с сеткой
     */

    @Override
    public EnclosureType move(Enclosure enclosure) {
        if (enclosure instanceof NettedEnclosure) {
            return EnclosureType.NETTED;
        } else {
            throw new IllegalArgumentException("Пернатое животное может быть помещено только в вольер с сеткой");
        }
    }
}