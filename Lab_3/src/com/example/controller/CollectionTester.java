package com.example.controller;

import com.example.model.Animal;
import com.example.util.Logger;
import com.example.util.RandomAnimalGenerator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Класс для тестирования операций с коллекциями.
 */

public class CollectionTester {
    private Logger logger;

    /**
     * Конструктор для создания тестера коллекций.
     * @param logger Логгер для записи логов.
     */

    public CollectionTester(Logger logger) {
        this.logger = logger;
    }

    /**
     * Тестирует операции с ArrayList.
     * @param size Размер коллекции.
     */

    public void testArrayListOperations(int size) {
        List<Animal> animals = new ArrayList<>();
        RandomAnimalGenerator generator = new RandomAnimalGenerator();
        long startTime = System.nanoTime();
        long addTotalTime = 0;
        long removeTotalTime = 0;
        int addCount = 0;
        int removeCount = 0;
        try {
            logger.log("ArrayListLog.txt", "Start program: " + java.time.LocalDateTime.now());
            logger.log("ArrayListLog.txt", "ArrayList");
            for (int i = 0; i < size; i++) {
                Animal product = generator.generateRandomAnimnal();
                long addStartTime = System.nanoTime();
                animals.add(product);
                long addEndTime = System.nanoTime();
                long addTime = addEndTime - addStartTime;
                addTotalTime += addTime;
                addCount++;
                logger.log("ArrayListLog.txt", "add, ID = " + i + ", " + addTime);
            }
            int removeCountTarget = size / 10;
            Random random = new Random();
            for (int i = 0; i < removeCountTarget; i++) {
                int index = random.nextInt(size);
                long removeStartTime = System.nanoTime();

                animals.remove(index);

                long removeEndTime = System.nanoTime();
                long removeTime = removeEndTime - removeStartTime;

                removeTotalTime += removeTime;
                removeCount++;
                size--;

                logger.log("ArrayListLog.txt", "remove, ID = " + index + ", " + removeTime);
            }

            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;

            logger.log("ArrayListLog.txt", "addTotalCount = " + addCount);
            logger.log("ArrayListLog.txt", "addTotalTime = " + addTotalTime);
            logger.log("ArrayListLog.txt", "addMedianTime = " + (addTotalTime / addCount));
            logger.log("ArrayListLog.txt", "removeTotalCount = " + removeCount);
            logger.log("ArrayListLog.txt", "removeTotalTime = " + removeTotalTime);
            logger.log("ArrayListLog.txt", "removeMedianTime = " + (removeTotalTime / removeCount));
            logger.log("ArrayListLog.txt", "Finish program: " + java.time.LocalDateTime.now());
            logger.log("ArrayListLog.txt", "Total time: " + totalTime + " ns");

        } catch (Exception e) {
            logger.log("ArrayListLog.txt", "Error: " + e.getMessage());
        }
    }

    /**
     * Тестирует операции с LinkedList.
     * @param size Размер коллекции.
     */

    public void testLinkedListOperations(int size) {
        List<Animal> animals = new LinkedList<>();
        RandomAnimalGenerator generator = new RandomAnimalGenerator();

        long startTime = System.nanoTime();
        long addTotalTime = 0;
        long removeTotalTime = 0;

        int addCount = 0;
        int removeCount = 0;

        try {
            logger.log("LinkedListLog.txt", "Start program: " + java.time.LocalDateTime.now());
            logger.log("LinkedListLog.txt", "LinkedList");

            for (int i = 0; i < size; i++) {
                Animal product = generator.generateRandomAnimnal();
                long addStartTime = System.nanoTime();
                animals.add(product);

                long addEndTime = System.nanoTime();
                long addTime = addEndTime - addStartTime;

                addTotalTime += addTime;
                addCount++;

                logger.log("LinkedListLog.txt", "add, ID = " + i + ", " + addTime);
            }

            int removeCountTarget = size / 10;
            Random random = new Random();

            for (int i = 0; i < removeCountTarget; i++) {
                int index = random.nextInt(size);
                long removeStartTime = System.nanoTime();
                animals.remove(index);

                long removeEndTime = System.nanoTime();
                long removeTime = removeEndTime - removeStartTime;

                removeTotalTime += removeTime;
                removeCount++;
                size--;

                logger.log("LinkedListLog.txt", "remove, ID = " + index + ", " + removeTime);
            }

            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;

            logger.log("LinkedListLog.txt", "addTotalCount = " + addCount);
            logger.log("LinkedListLog.txt", "addTotalTime = " + addTotalTime);
            logger.log("LinkedListLog.txt", "addMedianTime = " + (addTotalTime / addCount));
            logger.log("LinkedListLog.txt", "removeTotalCount = " + removeCount);
            logger.log("LinkedListLog.txt", "removeTotalTime = " + removeTotalTime);
            logger.log("LinkedListLog.txt", "removeMedianTime = " + (removeTotalTime / removeCount));
            logger.log("LinkedListLog.txt", "Finish program: " + java.time.LocalDateTime.now());
            logger.log("LinkedListLog.txt", "Total time: " + totalTime + " ns");

        } catch (Exception e) {
            logger.log("LinkedListLog.txt", "Error: " + e.getMessage());
        }
    }
}