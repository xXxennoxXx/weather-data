package pl.xxxennoxxx.weather.data.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.xxxennoxxx.weather.data.dtos.WeatherDTO;
import pl.xxxennoxxx.weather.data.dtos.WeatherRequest;
import pl.xxxennoxxx.weather.data.entities.WeatherData;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class WeatherUseCase {
    private final WeatherDataService weatherDataService;

    public WeatherDTO getById(WeatherRequest weatherRequest) {
        return weatherDataService.getById(weatherRequest);
    }

    public List<WeatherDTO> getAll() {
        return weatherDataService.getAll();
    }

    public WeatherDTO delete(WeatherRequest request) {
        return weatherDataService.delete(request);
    }

    public WeatherData add(WeatherDTO weatherData) {
        return null;
    }

    public WeatherData update(WeatherDTO weatherData) {
        return null;
    }
}
