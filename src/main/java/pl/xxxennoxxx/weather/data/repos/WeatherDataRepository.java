package pl.xxxennoxxx.weather.data.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.xxxennoxxx.weather.data.entities.WeatherData;

import java.util.Optional;

public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {

    Optional<WeatherData> findByPostCodeAndYearAndMonth(String postCode, Integer year, Integer month);
}