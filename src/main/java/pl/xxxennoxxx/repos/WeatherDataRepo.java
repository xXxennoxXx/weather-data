package pl.xxxennoxxx.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.xxxennoxxx.entities.WeatherData;
import pl.xxxennoxxx.entities.WeatherDataKey;
import pl.xxxennoxxx.services.report.entities.AvgPerYearResult;
import pl.xxxennoxxx.services.report.entities.HighestTempPerMonth;

import java.util.List;

public interface WeatherDataRepo extends JpaRepository<WeatherData, WeatherDataKey> {

    @Query(value = "select count(distinct w.weatherDataKey.postCode) from WeatherData w")
    Integer regionCount();

    @Query(value = "select new pl.xxxennoxxx.services.report.entities.AvgPerYearResult(w.weatherDataKey.year,avg (w.allRainfall))  from WeatherData w group by w.weatherDataKey.year")
    List<AvgPerYearResult> avgRainFallSumPerYear();

//    @Query(value = "select new pl.xxxennoxxx.services.report.entities.AvgPerYearResult(w.weatherDataKey.year,avg ())  from WeatherData w group by w.weatherDataKey.year")
//    List<AvgPerYearResult> greatestAvgTempPerYear();

    //najwyzsza temperatura

}
