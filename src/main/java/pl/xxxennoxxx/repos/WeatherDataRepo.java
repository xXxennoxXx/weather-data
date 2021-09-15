package pl.xxxennoxxx.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.xxxennoxxx.entities.WeatherData;

public interface WeatherDataRepo extends JpaRepository<WeatherData, Long> {
}
