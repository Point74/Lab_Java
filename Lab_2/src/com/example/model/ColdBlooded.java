package com.example.model;

import com.example.model.Enclosure;
import com.example.model.InfraredEnclosure;

//

/**
 * Класс, представляющий хладнокровное животное.
 */

public class ColdBlooded extends Animal {

    /**
     * Конструктор для создания нового хладнокровного животного.
     *
     * @param weight вес животного
     * @param age возраст животного
     */

    public ColdBlooded(double weight, int age) {
        super(weight, age);
    }

    /**
     * Перемещает хладнокровное животное в аквариум.
     *
     * @param enclosure вольер, в который перемещается животное
     * @throws IllegalArgumentException если вольер не с инфракрасным освещением
     */

    @Override
    public void move(Enclosure enclosure) {
        if (enclosure instanceof InfraredEnclosure) {
            System.out.println("Хладнокровное животное перемещено в вольер с инфракрасным освещением");
        } else {
            throw new IllegalArgumentException("Хладнокровное животное может быть помещено только в вольер с инфракрасным освещением");
        }
    }
}
