package pl.xxxennoxxx.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.xxxennoxxx.entities.WeatherData;
import pl.xxxennoxxx.repos.WeatherDataRepo;

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

    @GetMapping
    public WeatherData toDo(){
        WeatherData weatherData = new WeatherData();
        repo.save(weatherData);
        System.out.println("Id: "+weatherData.getId());
        List<WeatherData> select_w_from_weatherData_w = em.createQuery("select w from WeatherData w", WeatherData.class).getResultList();
        System.out.println("Size: "+select_w_from_weatherData_w.size());
        return weatherData;
    }
}
