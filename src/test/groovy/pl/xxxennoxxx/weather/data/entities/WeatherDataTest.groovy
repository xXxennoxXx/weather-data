package pl.xxxennoxxx.weather.data.entities

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import pl.xxxennoxxx.weather.data.repos.WeatherDataRepository
import spock.lang.Specification

import java.time.LocalDate

import static java.math.BigDecimal.ONE

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class WeatherDataTest extends Specification {

    @Autowired
    WeatherDataRepository weatherDataRepository

    def "should add data"() {
        when:
        weatherDataRepository.saveAndFlush(new WeatherData(
                postCode: '01-111',
                date: LocalDate.now(),
                minTemp: ONE,
                avgTemp: ONE,
                maxTemp: ONE,
                allRainfall: ONE,
                dailyMaxRainfall: ONE
        ))

        then:
        noExceptionThrown()

    }

    def "should throw exception on wrong post code"() {
        when:
        weatherDataRepository.saveAndFlush(new WeatherData(
                postCode: 'postCode',
                date: LocalDate.now(),
                minTemp: ONE,
                avgTemp: ONE,
                maxTemp: ONE,
                allRainfall: ONE,
                dailyMaxRainfall: ONE
        ))

        then:
        thrown(Exception)

    }

    def "should throw exception on null data"() {
        when:
        weatherDataRepository.saveAndFlush(new WeatherData(
                postCode: '11-011',
                date: LocalDate.now(),
                minTemp: null,
                avgTemp: ONE,
                maxTemp: ONE,
                allRainfall: ONE,
                dailyMaxRainfall: ONE
        ))

        then:
        thrown(Exception)

    }
}
