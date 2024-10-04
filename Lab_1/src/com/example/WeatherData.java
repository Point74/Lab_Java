package com.example;

/**
 * Класс для хранения данных о погоде.
 */

public class WeatherData {
    private final double[] temperatures;
    private final double[] precipitation;

    /**
     * Конструктор для создания объекта WeatherData.
     *
     * @param temperatures  массив температур за 30 дней
     * @param precipitation массив осадков за 30 дней
     * @throws IllegalArgumentException если длина массивов не равна 30
     */

    public WeatherData(double[] temperatures, double[] precipitation) {
        if (temperatures.length != 30 || precipitation.length != 30) {
            throw new IllegalArgumentException("Both arrays must contain data for 30 days.");
        }
        this.temperatures = temperatures;
        this.precipitation = precipitation;
    }

    /**
     * Получить массив температур.
     *
     * @return массив температур
     */

    public double[] getTemperatures() {
        return temperatures;
    }

    /**
     * Получить массив осадков.
     *
     * @return массив осадков
     */

    public double[] getPrecipitation() {
        return precipitation;
    }
}
