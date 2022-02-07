package pl.xxxennoxxx.weather.data.dtos;


import pl.xxxennoxxx.weather.data.utils.Result;

public class WeatherDTO {
    public String postCode;
    public Integer year;
    public Integer month;
    public Float minTemp;
    public Float avgTemp;
    public Float maxTemp;
    public Float allRainfall;
    public Float dailyMaxRainfall;

    public Result isCorrect() {
        if(postCode ==null
                ||year==null
                ||month==null
                ||minTemp==null
                ||avgTemp==null
                ||maxTemp==null
                ||allRainfall==null
                ||dailyMaxRainfall==null)
            return Result.negative("Błędne zapytanie");

        if (minTemp > avgTemp)
            return Result.negative("Minimalna temperatura nie może być większa od średniej");
        if (avgTemp > maxTemp)
            return Result.negative("Maksymalna temperatura nie może być mniejsza od średniej");
        if (dailyMaxRainfall > allRainfall)
            return Result.negative("Maksymalne dzienne opady nie mogą być większe od sumy miesięcznych opadów");
        return Result.positive();
    }
}
