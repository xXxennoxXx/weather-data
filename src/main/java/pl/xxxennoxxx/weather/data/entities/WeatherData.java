package pl.xxxennoxxx.weather.data.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class WeatherData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(sequenceName = "db_id_seq", name = "id_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id;

    @NotEmpty
    @Pattern(regexp = "\\d{2}-\\d{3}")
    private String postCode;

    @NotNull
    private LocalDate date;

    @NotNull
    private BigDecimal minTemp;

    @NotNull
    private BigDecimal avgTemp;

    @NotNull
    private BigDecimal maxTemp;

    @NotNull
    private BigDecimal allRainfall;

    @NotNull
    private BigDecimal dailyMaxRainfall;

}
