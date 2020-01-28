package com.wroclawhelperf.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class WeatherStation {

    private String shortName;
    private String name;
    private GPSLocation location;

    @Override
    public String toString() {
        return "WeatherStation{" +
                ", name='" + name + '\'' +
                ", location=" + location +
                '}';
    }
}
