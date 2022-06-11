package pl.xxxennoxxx.weather.data.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
public class WeatherRequest {
    private String postCode;
    private LocalDate date;
}
