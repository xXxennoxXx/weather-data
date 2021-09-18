package pl.xxxennoxxx.dtos;


import pl.xxxennoxxx.utils.Result;

public class WeatherDTO {
    public String postCode;
    public Integer year;
    public Integer month;
    public Float minTemp;
    public Float avgTemp;
    public Float maxTemp;
    public Float allRainfall;
    public Float dailyMaxRainfall;

    public Result isCorrect(){
        
        return Result.positive();
    }

}
