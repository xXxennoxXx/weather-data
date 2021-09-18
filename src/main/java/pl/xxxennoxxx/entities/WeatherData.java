package pl.xxxennoxxx.entities;

import javax.persistence.*;

@Entity
public class WeatherData {

    @EmbeddedId
    private WeatherDataKey weatherDataKey;
    private Float minTemp;
    private Float avgTemp;
    private Float maxTemp;
    private Float allRainfall;
    private Float dailyMaxRainfall;

    public WeatherData() {
    }

    public WeatherData(String postCode, Integer year, Integer month) {
        this.weatherDataKey = new WeatherDataKey(postCode, year, month);
    }


    public WeatherDataKey getWeatherDataKey() {
        return weatherDataKey;
    }

    public void setWeatherDataKey(WeatherDataKey weatherDataKey) {
        this.weatherDataKey = weatherDataKey;
    }

    public Float getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Float minTemp) {
        this.minTemp = minTemp;
    }

    public Float getAvgTemp() {
        return avgTemp;
    }

    public void setAvgTemp(Float avgTemp) {
        this.avgTemp = avgTemp;
    }

    public Float getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Float maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Float getAllRainfall() {
        return allRainfall;
    }

    public void setAllRainfall(Float allRainfall) {
        this.allRainfall = allRainfall;
    }

    public Float getDailyMaxRainfall() {
        return dailyMaxRainfall;
    }

    public void setDailyMaxRainfall(Float dailyMaxRainfall) {
        this.dailyMaxRainfall = dailyMaxRainfall;
    }
}
