package com.wroclawhelperf.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Weather {

    private LocalDateTime measuringTime;
    private double windSpeed;
    private double windDirection;
    private double humidity;
    private double airTemperature;
    private double groundTemperature;
    private String precipitationType;
    private String weatherStationName;

    @Override
    public String toString() {
        return "Weather{" +
                ", measuringTime=" + measuringTime +
                ", windSpeed=" + windSpeed +
                ", windDirection=" + windDirection +
                ", humidity=" + humidity +
                ", airTemperature=" + airTemperature +
                ", groundTemperature=" + groundTemperature +
                ", precipitationType='" + precipitationType + '\'' +
                ", weatherStation=" + weatherStationName +
                '}';
    }
}
