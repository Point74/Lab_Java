package com.example;

public class WeatherData {
    private final double[] temperatures;
    private final double[] precipitation;

    public WeatherData(double[] temperatures, double[] precipitation) {
        if (temperatures.length != 30 || precipitation.length != 30) {
            throw new IllegalArgumentException("Both arrays must contain data for 30 days.");
        }
        this.temperatures = temperatures;
        this.precipitation = precipitation;
    }

    public double[] getTemperatures() {
        return temperatures;
    }

    public double[] getPrecipitation() {
        return precipitation;
    }
}
