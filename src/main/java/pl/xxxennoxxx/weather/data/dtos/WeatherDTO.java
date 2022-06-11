package pl.xxxennoxxx.weather.data.dtos;


import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import pl.xxxennoxxx.weather.data.entities.WeatherData;
import pl.xxxennoxxx.weather.data.utils.Result;

import static java.util.Objects.isNull;

@Data
@Builder
@RequiredArgsConstructor
public class WeatherDTO {
    private final String postCode;
    private final Integer year;
    private final Integer month;
    private final Double minTemp;
    private final Double avgTemp;
    private final Double maxTemp;
    private final Double allRainfall;
    private final Double dailyMaxRainfall;

    public Result isCorrect() {
        if (isNull(postCode)
                || isNull(year)
                || isNull(month)
                || isNull(minTemp)
                || isNull(avgTemp)
                || isNull(maxTemp)
                || isNull(allRainfall)
                || isNull(dailyMaxRainfall))
            return Result.negative("Błędne zapytanie");

        if (minTemp > avgTemp)
            return Result.negative("Minimalna temperatura nie może być większa od średniej");
        if (avgTemp > maxTemp)
            return Result.negative("Maksymalna temperatura nie może być mniejsza od średniej");
        if (dailyMaxRainfall > allRainfall)
            return Result.negative("Maksymalne dzienne opady nie mogą być większe od sumy miesięcznych opadów");
        return Result.positive();
    }

    public static WeatherDTO of(WeatherData weatherData) {
        return WeatherDTO.builder()
                .postCode(weatherData.getPostCode())
                .year(weatherData.getDate().getYear())
                .month(weatherData.getDate().getMonthValue())
                .minTemp(weatherData.getMinTemp().doubleValue())
                .avgTemp(weatherData.getAvgTemp().doubleValue())
                .maxTemp(weatherData.getMaxTemp().doubleValue())
                .allRainfall(weatherData.getAllRainfall().doubleValue())
                .dailyMaxRainfall(weatherData.getDailyMaxRainfall().doubleValue())
                .build();
    }
}
