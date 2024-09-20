package com.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<Enclosure> enclosures;
    private ZooView view;

    public Main() {
        enclosures = new ArrayList<>();
        // Инициализация вольеров
        enclosures.add(new Aquarium(10));
        enclosures.add(new NettedEnclosure(20));
        enclosures.add(new OpenEnclosure(15));
        enclosures.add(new InfraredEnclosure(5));
        view = new ZooView();
    }

    public void distributeAnimal(Animal animal) {
        for (Enclosure enclosure : enclosures) {
            try {
                animal.move(enclosure);
                enclosure.addAnimal(animal);
                return;
            } catch (IllegalArgumentException | IllegalStateException e) {
                // Продолжаем поиск подходящего вольера
            }
        }
        view.displayMessage("Не удалось найти подходящий вольер для животного");
    }

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