package pl.xxxennoxxx.weather.data.controllers

import com.blogspot.toomuchcoding.spock.subjcollabs.Collaborator
import com.blogspot.toomuchcoding.spock.subjcollabs.Subject
import pl.xxxennoxxx.weather.data.dtos.WeatherDTO
import pl.xxxennoxxx.weather.data.dtos.WeatherRequest
import pl.xxxennoxxx.weather.data.entities.WeatherData
import pl.xxxennoxxx.weather.data.exeptions.NotFoundException
import pl.xxxennoxxx.weather.data.repos.WeatherDataRepository
import spock.lang.Specification

import java.time.Clock
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

import static java.math.BigDecimal.ONE

class WeatherDataServiceTest extends Specification {

    @Subject
    WeatherDataService sub

    @Collaborator
    WeatherDataRepository weatherDataRepository = Mock()

    Clock clock = Clock.fixed(Instant.parse("2022-01-01T10:00:00.00Z"), ZoneId.systemDefault());

    def "should throw exception on data not found"() {
        given:
        def request = new WeatherRequest('11-111', LocalDate.now(clock))
        weatherDataRepository.findByPostCodeAndYearAndMonth(*_) >> Optional.empty()

        when:
        sub.getById(request)

        then:
        thrown(NotFoundException)
    }

    def "should get weather data"() {
        given:
        def request = new WeatherRequest('11-111', LocalDate.now(clock))
        def weatherData = new WeatherData(2, "11-111", LocalDate.now(clock), ONE, ONE, ONE, ONE, ONE)
        weatherDataRepository.findByPostCodeAndYearAndMonth(*_) >> Optional.of(weatherData)

        when:
        def result = sub.getById(request)

        then:
        noExceptionThrown()
        result == WeatherDTO.of(weatherData)
    }
}
