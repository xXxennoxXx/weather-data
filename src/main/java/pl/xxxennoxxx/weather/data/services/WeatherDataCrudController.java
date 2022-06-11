package pl.xxxennoxxx.weather.data.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pl.xxxennoxxx.weather.data.dtos.WeatherDTO;
import pl.xxxennoxxx.weather.data.dtos.WeatherRequest;

@Service
@RequestMapping("/")
public class WeatherDataCrudController {

    @DeleteMapping
    public void delete(WeatherRequest weatherRequest) {

    }

    @PostMapping
    public void add(WeatherDTO weatherDTO) {

    }

    @PutMapping
    public void update(WeatherDTO weatherDTO) {

    }

    @GetMapping
    public void get(WeatherRequest weatherRequest) {

    }
}
