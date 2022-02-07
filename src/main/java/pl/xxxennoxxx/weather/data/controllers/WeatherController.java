package pl.xxxennoxxx.weather.data.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.xxxennoxxx.weather.data.dtos.WeatherDTO;
import pl.xxxennoxxx.weather.data.entities.WeatherData;
import pl.xxxennoxxx.weather.data.utils.Result;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
@RequestMapping(value = "/weather")
public class WeatherController {
//    private final WeatherDataRepo repo;
    @PersistenceContext
    private EntityManager em;

//    public WeatherController(WeatherDataRepo repo) {
//        this.repo = repo;
//    }
//
//    @GetMapping(value = "/")
//    public WeatherData getById(@RequestBody WeatherDataKey keyDTO) {
//        return isEntityExists(keyDTO.getPostCode(), keyDTO.getYear(), keyDTO.getMonth());
//    }
//
//    @GetMapping(value = "/all")
//    public List<WeatherData> getAll() {
//        return repo.findAll();
//    }
//
//
//    @DeleteMapping
//    public WeatherData delete(@RequestBody WeatherDataKey keyDTO) {
//        WeatherData data = isEntityExists(keyDTO.getPostCode(), keyDTO.getYear(), keyDTO.getMonth());
//        repo.delete(data);
//        return data;
//    }
//
//    @PutMapping
//    public WeatherData add(@RequestBody WeatherDTO wd) {
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

//    @PostMapping
//    public WeatherData update(@RequestBody WeatherDTO wd) {
//        Result result = wd.isCorrect();
//        if (!result.isPositive()) {
//            throw new ResponseStatusException(
//                    HttpStatus.BAD_REQUEST, result.getMsg());
//        }
//
//        WeatherData weatherData = new WeatherData();
////        weatherData.setAvgTemp(wd.avgTemp);
////        weatherData.setMinTemp(wd.minTemp);
////        weatherData.setMaxTemp(wd.maxTemp);
////        weatherData.setAllRainfall(wd.allRainfall);
////        weatherData.setDailyMaxRainfall(wd.dailyMaxRainfall);
//
//        return repo.save(weatherData);
//    }

    private WeatherData isEntityExists(String postCode, Integer year, Integer month) {
//        WeatherDataKey key = new WeatherDataKey();//postCode, year, month);
//        if (!repo.existsById(key))
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND, "No entity with id: " + postCode + ", " + year + ", " + month);
//        return repo.getById(key);
        return null;
    }


}
