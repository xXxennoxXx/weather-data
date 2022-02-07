package pl.xxxennoxxx.weather.data.entities

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import pl.xxxennoxxx.weather.data.repos.WeatherDataRepository
import spock.lang.Specification

import java.time.LocalDate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class WeatherDataTest extends Specification {

    @Autowired
    WeatherDataRepository weatherDataRepository

    def "should add data"() {
        when:
        weatherDataRepository.saveAndFlush(new WeatherData(
                postCode: '01-111',
                date: LocalDate.now(),
                minTemp: BigDecimal.ONE,
                avgTemp: BigDecimal.ONE,
                maxTemp: BigDecimal.ONE,
                allRainfall: BigDecimal.ONE,
                dailyMaxRainfall: BigDecimal.ONE
        ))

        then:
        noExceptionThrown()

    }

    def "should throw exception on wrong post code"() {
        when:
        weatherDataRepository.saveAndFlush(new WeatherData(
                postCode: 'postCode',
                date: LocalDate.now(),
                minTemp: BigDecimal.ONE,
                avgTemp: BigDecimal.ONE,
                maxTemp: BigDecimal.ONE,
                allRainfall: BigDecimal.ONE,
                dailyMaxRainfall: BigDecimal.ONE
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
                avgTemp: BigDecimal.ONE,
                maxTemp: BigDecimal.ONE,
                allRainfall: BigDecimal.ONE,
                dailyMaxRainfall: BigDecimal.ONE
        ))

        then:
        thrown(Exception)

    }
}
