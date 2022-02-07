package pl.xxxennoxxx.weather.data.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.xxxennoxxx.weather.data.entities.WeatherData;

public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
}