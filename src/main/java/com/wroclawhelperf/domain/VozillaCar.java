package com.wroclawhelperf.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class VozillaCar {

    private String platesNumber;
    private String sideNumber;
    private String color;
    private String type;
    private int rangeKm;
    private int batteryLevelPct;
    private String status;
    private String address;
    private String name;
    private GPSLocation location;

    @Override
    public String toString() {
        return "VozillaCarDto{" +
                "platesNumber='" + platesNumber + '\'' +
                ", sideNumber='" + sideNumber + '\'' +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                ", rangeKm=" + rangeKm +
                ", batteryLevelPct=" + batteryLevelPct +
                ", status='" + status + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", location=" + location +
                '}';
    }
}
