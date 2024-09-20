package com.example;

public class WeatherView {
    public void displayResults(int snowfall, int rainfall, String season) {
        System.out.println("Результаты анализа погоды:");
        System.out.println("Количество осадков в виде снега: " + snowfall + " мм");
        System.out.println("Количество осадков в виде дождя: " + rainfall + " мм");
        System.out.println("Время года: " + season);
    }
}
