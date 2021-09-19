package pl.xxxennoxxx.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.xxxennoxxx.services.report.WeatherReportService;
import pl.xxxennoxxx.services.report.entities.AvgPerYearResult;
import pl.xxxennoxxx.services.report.entities.HighestAvgTempPerYear;
import pl.xxxennoxxx.services.report.entities.HighestTempPerMonth;
import pl.xxxennoxxx.services.report.entities.PercentOfRainDayPerMonth;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/weather/report/")
public class WeatherReportController {

    private final WeatherReportService weatherReportService;

    public WeatherReportController(WeatherReportService weatherReportService) {
        this.weatherReportService = weatherReportService;
    }


    @GetMapping(value = "/regionCount")
    public Integer regionCount() {
        return weatherReportService.regionCount();
    }

    @GetMapping(value = "/avgRainfallSumPerYear")
    public List<AvgPerYearResult> avgRainfallSumPerYear() {
        return weatherReportService.avgRainfallSumPerYear();
    }

    @GetMapping(value = "/monthWithHighestTemp")
    public List<HighestTempPerMonth> monthWithHighestTemp() {
        return weatherReportService.monthWithHighestTemp();
    }

    @GetMapping(value = "/percentOfRainDayPerMonth")
    public List<PercentOfRainDayPerMonth> percentOfRainDayPerMonth() {
        return weatherReportService.percentOfRainDayPerMonth();
    }

    @GetMapping(value = "/highestAvgAvgTempPerYear")
    public List<HighestAvgTempPerYear> highestAvgAvgTempPerYear() {
        return weatherReportService.highestAvgAvgTempPerYear();
    }

}
