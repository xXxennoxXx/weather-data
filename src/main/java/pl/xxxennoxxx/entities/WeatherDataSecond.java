package pl.xxxennoxxx.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WeatherDataSecond {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
