package com.example.model;

// Model

/**
 * Класс, представляющий копытное животное.
 */

public class Ungulate extends Animal {

    /**
     * Конструктор для создания нового копытного животного.
     *
     * @param weight вес животного
     * @param age возраст животного
     */

    public Ungulate(double weight, int age) {
        super(weight, age);
    }

    /**
     * Перемещает копытное животное в открытый вольер.
     *
     * @param enclosure вольер, в который перемещается животное
     * @return
     * @throws IllegalArgumentException если вольер не является открытым
     */

    @Override
    public EnclosureType move(Enclosure enclosure) {
        if (enclosure instanceof OpenEnclosure) {
            return EnclosureType.OPEN;
        } else {
            throw new IllegalArgumentException("Копытное животное может быть помещено только в открытый вольер");
        }
    }
}

