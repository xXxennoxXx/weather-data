package pl.xxxennoxxx.weather.data.report.entities;

public class HighestAvgTempPerYear {
    public Integer year;
    public String postCode;
    public Double avgTemp;

    public HighestAvgTempPerYear(Integer year, String postCode, Double avgTemp) {
        this.year = year;
        this.postCode = postCode;
        this.avgTemp = avgTemp;
    }
}
