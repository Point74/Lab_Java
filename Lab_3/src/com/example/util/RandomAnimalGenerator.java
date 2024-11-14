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
                return new ColdBlooded(random.nextInt(30)+1, random.nextInt(5)+5);
            case 1:
                return new Ungulate(random.nextInt(30)+1, random.nextInt(5)+5);
            case 2:
                return new Avian(random.nextInt(30)+1, random.nextInt(5)+5);
            case 3:
                return new Aquatic(random.nextInt(30)+1, random.nextInt(5)+5);
            default:
                return null;
        }
    }
}