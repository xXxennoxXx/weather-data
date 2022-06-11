package pl.xxxennoxxx.weather.data.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.xxxennoxxx.weather.data.dtos.WeatherDTO;
import pl.xxxennoxxx.weather.data.dtos.WeatherRequest;
import pl.xxxennoxxx.weather.data.entities.WeatherData;

import java.util.List;

@RestController
@RequestMapping(value = "/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherUseCase weatherUseCase;

    @GetMapping
    public WeatherDTO getById(@RequestBody WeatherRequest weatherRequest) {
        return weatherUseCase.getById(weatherRequest);
    }

    @GetMapping(value = "/all")
    public List<WeatherDTO> getAll() {
        return weatherUseCase.getAll();
    }

    @DeleteMapping
    public WeatherDTO delete(@RequestBody WeatherRequest weatherRequest) {
        return weatherUseCase.delete(weatherRequest);
    }

    @PutMapping
    public WeatherData add(@RequestBody WeatherDTO wd) {
        return weatherUseCase.add(wd);
    }

    @PostMapping
    public WeatherData update(@RequestBody WeatherDTO wd) {
        return weatherUseCase.update(wd);
    }

}