package pl.xxxennoxxx.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.xxxennoxxx.dtos.WeatherDTO;
import pl.xxxennoxxx.entities.WeatherData;
import pl.xxxennoxxx.repos.WeatherDataRepo;

import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequestMapping(value = "/weather")
public class WeatherController {
    @Autowired
    private WeatherDataRepo repo;
    @PersistenceContext
    private EntityManager em;


    @DeleteMapping
    public WeatherData delete(@RequestParam("id") int id){
        WeatherData weatherData = new WeatherData("",11,1);
        repo.save(weatherData);
        List<WeatherData> select_w_from_weatherData_w = em.createQuery("select w from WeatherData w", WeatherData.class).getResultList();
        System.out.println("Size: "+select_w_from_weatherData_w.size());
        return weatherData;
    }

    @PutMapping
    public WeatherData add(@RequestBody WeatherDTO wd){
        WeatherData weatherData = new WeatherData(wd.postCode,wd.year,wd.month);
        repo.save(weatherData);
        List<WeatherData> select_w_from_weatherData_w = em.createQuery("select w from WeatherData w", WeatherData.class).getResultList();
        System.out.println("Size: "+select_w_from_weatherData_w.size());
        return weatherData;
    }

    @PostMapping
    public WeatherData update(@RequestParam("id") int id){
        WeatherData weatherData = new WeatherData("",11,1);
        repo.save(weatherData);
        List<WeatherData> select_w_from_weatherData_w = em.createQuery("select w from WeatherData w", WeatherData.class).getResultList();
        System.out.println("Size: "+select_w_from_weatherData_w.size());
        return weatherData;
    }

    @GetMapping(value = "/{id}")
    public WeatherData getById( @PathVariable String id){
        WeatherData weatherData = new WeatherData("",11,1);
        repo.save(weatherData);
        List<WeatherData> select_w_from_weatherData_w = em.createQuery("select w from WeatherData w", WeatherData.class).getResultList();
        System.out.println("Size: "+select_w_from_weatherData_w.size());
        return weatherData;
    }

    @GetMapping(value = "/all")
    public WeatherData getAll( ){
        WeatherData weatherData = new WeatherData();
        repo.save(weatherData);
        List<WeatherData> select_w_from_weatherData_w = em.createQuery("select w from WeatherData w", WeatherData.class).getResultList();
        System.out.println("Size: "+select_w_from_weatherData_w.size());
        return weatherData;
    }
}
