package pl.xxxennoxxx.weather.data.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.xxxennoxxx.weather.data.dtos.WeatherDTO;
import pl.xxxennoxxx.weather.data.dtos.WeatherRequest;
import pl.xxxennoxxx.weather.data.entities.WeatherData;
import pl.xxxennoxxx.weather.data.exeptions.NotFoundException;
import pl.xxxennoxxx.weather.data.repos.WeatherDataRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class WeatherDataService {
    private final WeatherDataRepository weatherDataRepository;

    public List<WeatherDTO> getAll() {
        return weatherDataRepository.findAll()
                .stream()
                .map(WeatherDTO::of)
                .collect(toList());
    }

    public WeatherDTO getById(WeatherRequest weatherRequest) {
        return WeatherDTO.of(getWeatherData(weatherRequest));
    }

    public WeatherDTO delete(WeatherRequest weatherRequest) {
        WeatherData weatherData = getWeatherData(weatherRequest);
        weatherDataRepository.delete(weatherData);
        return WeatherDTO.of(weatherData);
    }
//
//    public WeatherData add(WeatherDTO wd) {
//        Result result = wd.isCorrect();
//        if (!result.isPositive()) {
//            throw new ResponseStatusException(
//                    HttpStatus.BAD_REQUEST, result.getMsg());
//        }
//        WeatherData weatherData = isEntityExists(wd.postCode, wd.year, wd.month);
//        weatherData.setAvgTemp(wd.avgTemp);
//        weatherData.setMinTemp(wd.minTemp);
//        weatherData.setMaxTemp(wd.maxTemp);
//        weatherData.setAllRainfall(wd.allRainfall);
//        weatherData.setDailyMaxRainfall(wd.dailyMaxRainfall);
//        repo.save(weatherData);
//        return weatherData;
//    }
//
//    public WeatherData update(WeatherDTO wd) {
//        Result result = wd.isCorrect();
//        if (!result.isPositive()) {
//            throw new ResponseStatusException(
//                    HttpStatus.BAD_REQUEST, result.getMsg());
//        }
//
//        WeatherData weatherData = new WeatherData();
//        weatherData.setAvgTemp(wd.avgTemp);
//        weatherData.setMinTemp(wd.minTemp);
//        weatherData.setMaxTemp(wd.maxTemp);
//        weatherData.setAllRainfall(wd.allRainfall);
//        weatherData.setDailyMaxRainfall(wd.dailyMaxRainfall);
//
//        return repo.save(weatherData);
//    }
//
//    private WeatherData isEntityExists(String postCode, Integer year, Integer month) {
//        WeatherDataKey key = new WeatherDataKey();//postCode, year, month);
//        if (!repo.existsById(key))
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND, "No entity with id: " + postCode + ", " + year + ", " + month);
//        return repo.getById(key);
//        return null;
//    }

    private WeatherData getWeatherData(WeatherRequest weatherRequest) {
        return weatherDataRepository.findByPostCodeAndYearAndMonth(
                        weatherRequest.getPostCode(),
                        weatherRequest.getDate().getYear(),
                        weatherRequest.getDate().getMonthValue())
                .orElseThrow(() -> new NotFoundException("Not found"));
    }
}
