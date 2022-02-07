package pl.xxxennoxxx.weather.data.report.entities;

public class AvgPerYearResult {

    public Integer region;
    public Double rainfallSum;

    public AvgPerYearResult(Integer region, Double rainfallSum) {
        this.region = region;
        this.rainfallSum = rainfallSum;
    }
}
