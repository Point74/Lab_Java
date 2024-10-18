package com.example.controller;

import com.example.model.*;
import com.example.view.ZooView;

import java.util.ArrayList;
import java.util.List;
import com.example.util.Logger;

/**
 * Главный класс приложения, объединяющий функциональность контроллера и точки входа.
 */

public class Main {
    private final List<Enclosure> enclosures;
    private final ZooView view;

    /**
     * Конструктор, инициализирующий зоопарк.
     */

    public Main() {
        enclosures = new ArrayList<>();
        // Инициализация вольеров
        enclosures.add(new Aquarium(10));
        enclosures.add(new NettedEnclosure(20));
        enclosures.add(new OpenEnclosure(15));
        enclosures.add(new InfraredEnclosure(5));
        view = new ZooView();
    }

    /**
     * Распределяет животное по соответствующему вольеру.
     *
     * @param animal животное для распределения
     */

    public void distributeAnimal(Animal animal) {
        for (Enclosure enclosure : enclosures) {
            try {
                var typeOfEnclosure = animal.move(enclosure);
                switch (typeOfEnclosure) {
                    case OPEN -> view.displayMessage("Копытное животное перемещенно в вольер");
                    case INFRARED -> view.displayMessage("Хладнокровное животное перемещено в вольер с инфракрасный освещением");
                    case NETTED -> view.displayMessage("Пернатое животное перемещено в вольер с сеткой");
                    case AQUARIUM -> view.displayMessage("Водоплавающее животное перемещено в аквариум");
                }
                enclosure.addAnimal(animal);
                return;

            } catch (IllegalArgumentException | IllegalStateException e) {
                // Продолжаем поиск подходящего вольера
            }
        }
        view.displayMessage("Не удалось найти подходящий вольер для животного");
    }

    /**
     * Точка входа в приложение.
     *
     * @param args аргументы командной строки (не используются)
     */

    public static void main(String[] args) {
        Main zoo = new Main();

        try {
            Animal aquatic = new Aquatic(5.0, 2);
            Animal avian = new Avian(1.5, 3);
            Animal ungulate = new Ungulate(200.0, 5);
            Animal coldBlooded = new ColdBlooded(2.0, 1);

            zoo.distributeAnimal(aquatic);
            zoo.distributeAnimal(avian);
            zoo.distributeAnimal(ungulate);
            zoo.distributeAnimal(coldBlooded);
        } catch (Exception e) {
            zoo.view.displayMessage("Ошибка: " + e.getMessage());
        }
    }
}