package com.example;

// Combined Controller and Main class

/**
 * Основной класс для анализа погоды, объединяющий функции контроллера и точки входа.
 */

public class Main {
    private final WeatherData model;
    private final WeatherView view;

    /**
     * Конструктор для создания объекта WeatherAnalysis.
     *
     * @param model модель данных о погоде
     * @param view  представление для отображения результатов
     */

    public Main (WeatherData model, WeatherView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Анализировать погоду и отобразить результаты.
     */

    public void analyzeWeather() {
        int snowfall = 0;
        int rainfall = 0;
        double[] temperatures = model.getTemperatures();
        double[] precipitation = model.getPrecipitation();

        for (int i = 0; i < 30; i++) {
            if (temperatures[i] >= 0) {
                rainfall += (int) precipitation[i];
            } else {
                snowfall += (int) precipitation[i];
            }
        }

        String season = determineSeason(temperatures);
        view.displayResults(snowfall, rainfall, season);
    }

    /**
     * Определить время года на основе температурных данных.
     *
     * @param temperatures массив температур
     * @return определенное время года
     */

    private String determineSeason(double[] temperatures) {
        double averageTemp = calculateAverage(temperatures);
        int consecutiveDaysAboveZero = 0;
        int maxConsecutiveDaysAboveZero = 0;
        double maxPositiveTemp = Double.MIN_VALUE;
        double minNegativeTemp = Double.MAX_VALUE;
        double maxTemp = Double.MIN_VALUE;
        double minTemp = Double.MAX_VALUE;

        for (int i = 0; i < 30; i++) {
            if (temperatures[i] >= 0) {
                consecutiveDaysAboveZero++;
                if (temperatures[i] > maxPositiveTemp) {
                    maxPositiveTemp = temperatures[i];
                }
            } else {
                if (temperatures[i] < minNegativeTemp) {
                    minNegativeTemp = temperatures[i];
                }
                maxConsecutiveDaysAboveZero = Math.max(maxConsecutiveDaysAboveZero, consecutiveDaysAboveZero);
                consecutiveDaysAboveZero = 0;
            }

            if (temperatures[i] > maxTemp) {
                maxTemp = temperatures[i];
            }
            if (temperatures[i] < minTemp) {
                minTemp = temperatures[i];
            }
        }
        maxConsecutiveDaysAboveZero = Math.max(maxConsecutiveDaysAboveZero, consecutiveDaysAboveZero);

        if (averageTemp < 0 || (maxPositiveTemp <= 5 && maxConsecutiveDaysAboveZero >= 14 && minNegativeTemp < -7)) {
            return "Зима";
        } else if (averageTemp > 15 || (minTemp >= 0 && maxConsecutiveDaysAboveZero >= 14 && maxTemp > 20)) {
            return "Лето";
        } else {
            return "Весна или Осень";
        }
    }

    /**
     * Вычислить среднее значение массива.
     *
     * @param arr массив чисел
     * @return среднее значение
     */

    private double calculateAverage(double[] arr) {
        double sum = 0;
        for (double v : arr) {
            sum += v;
        }
        return sum / arr.length;
    }

    /**
     * Точка входа в программу.
     *
     * @param args аргументы командной строки (не используются)
     */

    public static void main(String[] args) {
        try {
            double[] temperatures = inputTemperatures();
            double[] precipitation = inputPrecipitation();

            WeatherData model = new WeatherData(temperatures, precipitation);
            WeatherView view = new WeatherView();
            Main weatherAnalysis = new Main(model, view);

            weatherAnalysis.analyzeWeather();
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    /**
     * Ввод температур (в данном примере генерируются случайные значения).
     *
     * @return массив температур за 30 дней
     */

    private static double[] inputTemperatures() {
        // ввод температур
        // для примера используем случайные значения
        double[] temperatures = new double[30];
        for (int i = 0; i < 30; i++) {
            temperatures[i] = Math.random() * 40 - 20; // от -20 до +20
        }
        return temperatures;
    }

    /**
     * Ввод осадков (в данном примере генерируются случайные значения).
     *
     * @return массив осадков за 30 дней
     */

    private static double[] inputPrecipitation() {
        // ввод осадков
        // для примера используем случайные значения
        double[] precipitation = new double[30];
        for (int i = 0; i < 30; i++) {
            precipitation[i] = Math.random() * 10; // от 0 до 10 мм
        }
        return precipitation;
    }
}