package pl.xxxennoxxx.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class WeatherDataKey implements Serializable {

    @Column(nullable = false,length = 6)
    private String postCode;
    @Column(nullable = false,length = 4)
    private Integer year;
    @Column(nullable = false,length = 2)
    private Integer month;

    public WeatherDataKey() {
    }

    public WeatherDataKey(String postCode, Integer year, Integer month) {
        this.postCode = postCode;
        this.year = year;
        this.month = month;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherDataKey that = (WeatherDataKey) o;
        return postCode.equals(that.postCode) &&
                year.equals(that.year) &&
                month.equals(that.month);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postCode, year, month);
    }
}
