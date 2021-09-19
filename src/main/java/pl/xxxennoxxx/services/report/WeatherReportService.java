package pl.xxxennoxxx.services.report;

import pl.xxxennoxxx.services.report.entities.AvgPerYearResult;
import pl.xxxennoxxx.services.report.entities.HighestAvgTempPerYear;
import pl.xxxennoxxx.services.report.entities.HighestTempPerMonth;
import pl.xxxennoxxx.services.report.entities.PercentOfRainDayPerMonth;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public interface WeatherReportService {
    public Integer regionCount();

    public List<AvgPerYearResult> avgRainfallSumPerYear();

    public List<HighestTempPerMonth> monthWithHighestTemp();

    public List<PercentOfRainDayPerMonth> percentOfRainDayPerMonth();

    public List<HighestAvgTempPerYear> highestAvgAvgTempPerYear();


}
