package com.example.util;

import java.util.Random;
import com.example.model.*;

/**
 * Класс для генерации случайных животных.
 */

public class RandomAnimalGenerator {
    private static final String[] INFRARED = {"Лягушка", "Змея", "Ящерица", "Улитка"};
    private static final String[] OPEN = {"Лошадь", "Зебра", "Олень", "Лось"};
    private static final String[] NETTED = {"Попугай", "Утка", "Гусь", "Голубь"};
    private static final String[] AQUARIUM = {"Золотая рыбка", "Вуалехвост", "Рыба-клоун"};
    private final Random random;

    /**
     * Конструктор для создания генератора случайных животных.
     */

    public RandomAnimalGenerator() {
        this.random = new Random();
    }

    /**
     * Генерирует случайное животное.
     * @return Случайное животное.
     */

    public Animal generateRandomAnimnal() {
        int type = random.nextInt(4);
        switch (type) {
            case 0:
                return new ColdBlooded(INFRARED[random.nextInt(INFRARED.length)], random.nextDouble() * 1000 + 500);
            case 1:
                return new Ungulate(OPEN[random.nextInt(OPEN.length)], random.nextDouble() * 500 + 300);
            case 2:
                return new Avian(NETTED[random.nextInt(NETTED.length)], random.nextDouble() * 2000 + 1000);
            case 3:
                return new Aquatic(AQUARIUM[random.nextInt(AQUARIUM.length)], random.nextDouble() * 1500 + 1000);
            default:
                return null;
        }
    }
}