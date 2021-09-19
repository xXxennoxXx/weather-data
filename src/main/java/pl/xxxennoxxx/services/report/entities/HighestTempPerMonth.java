package pl.xxxennoxxx.services.report.entities;

public class HighestTempPerMonth {

    public Integer year;
    public Integer month;
    public Double temp;

    public HighestTempPerMonth(Integer year, Integer month, Double temp) {
        this.year = year;
        this.month = month;
        this.temp = temp;
    }
}
