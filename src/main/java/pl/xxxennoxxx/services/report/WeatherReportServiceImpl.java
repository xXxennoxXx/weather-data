package pl.xxxennoxxx.services.report;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import pl.xxxennoxxx.repos.WeatherDataRepo;
import pl.xxxennoxxx.services.report.entities.AvgPerYearResult;
import pl.xxxennoxxx.services.report.entities.HighestAvgTempPerYear;
import pl.xxxennoxxx.services.report.entities.HighestTempPerMonth;
import pl.xxxennoxxx.services.report.entities.PercentOfRainDayPerMonth;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WeatherReportServiceImpl implements WeatherReportService  {

    private final WeatherDataRepo repo;
    @PersistenceContext
    private final EntityManager em;

    public WeatherReportServiceImpl(WeatherDataRepo repo, EntityManager em) {
        this.repo = repo;
        this.em = em;
    }



    @Override
    public Integer regionCount() {
        return repo.regionCount();
    }

    @Override
    public List<AvgPerYearResult> avgRainfallSumPerYear() {
        return repo.avgRainFallSumPerYear();
    }

    @Override
    public List<HighestTempPerMonth> monthWithHighestTemp() {
        @SuppressWarnings("unchecked")
        List<Object[]> resultList = em.createNativeQuery(
                "select " +
                        "  year, " +
                        "  month, " +
                        "  AVG_TEMP " +
                        "from " +
                        "  WEATHER_DATA " +
                        "where " +
                        "  AVG_TEMP = (" +
                        "    SELECT " +
                        "      max(AVG_TEMP)" +
                        "    FROM " +
                        "      WEATHER_DATA" +
                        "  )").getResultList();

        return resultList.stream()
                .map(o -> new HighestTempPerMonth((Integer) o[0], (Integer) o[1], (Double) o[2]))
                .collect(Collectors.toList());
    }

    @Override
    public List<PercentOfRainDayPerMonth> percentOfRainDayPerMonth() {
        @SuppressWarnings("unchecked")
        List<Object[]> resultList = em.createNativeQuery("select year, month,nvl((select count(1) from WEATHER_DATA in where in.ALL_RAINFALL =0 and in.year = out.year and in.month = out.month group by year, month ),0),count(1) from WEATHER_DATA out group by year, month").getResultList();
        return resultList.stream()
                .map(o -> {
                    BigInteger without = (BigInteger) o[2];
                    BigInteger all = (BigInteger) o[3];
                    Double percent = without.doubleValue() / all.doubleValue();
                    return new PercentOfRainDayPerMonth((Integer) o[0], (Integer) o[1], percent);
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<HighestAvgTempPerYear> highestAvgAvgTempPerYear() {
        @SuppressWarnings("unchecked")
        List<Object[]> resultList = em.createNativeQuery("select year, POST_CODE, avg(AVG_TEMP ) a from WEATHER_DATA out group by year, POST_CODE having avg(AVG_TEMP ) = (SELECT  max(a) FROM (select year, POST_CODE, avg(AVG_TEMP ) a from WEATHER_DATA    group by year, POST_CODE ) in where in.year = out.year  group by year)").getResultList();
        return resultList.stream()
                .map(o -> new HighestAvgTempPerYear((Integer) o[0], (String) o[1], (Double) o[2]))
                .collect(Collectors.toList());
    }



}
