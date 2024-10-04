package com.example;

/**
 * Класс для отображения результатов анализа погоды.
 */

public class WeatherView {

    /**
     * Отобразить результаты анализа погоды.
     *
     * @param snowfall количество снега
     * @param rainfall количество дождя
     * @param season   определенное время года
     */

    public void displayResults(int snowfall, int rainfall, String season) {
        System.out.println("Результаты анализа погоды:");
        System.out.println("Количество осадков в виде снега: " + snowfall + " мм");
        System.out.println("Количество осадков в виде дождя: " + rainfall + " мм");
        System.out.println("Время года: " + season);
    }
}
