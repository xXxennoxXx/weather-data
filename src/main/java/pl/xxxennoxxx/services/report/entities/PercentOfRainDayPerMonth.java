package pl.xxxennoxxx.services.report.entities;

public class PercentOfRainDayPerMonth {
    public Integer year;
    public Integer month;
    public Double percent;

    public PercentOfRainDayPerMonth(Integer year, Integer month, Double percent) {
        this.year = year;
        this.month = month;
        this.percent = percent;
    }
}
