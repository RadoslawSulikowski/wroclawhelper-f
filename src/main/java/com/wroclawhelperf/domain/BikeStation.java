package com.wroclawhelperf.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BikeStation {

    Long uniqueId;
    int number;
    int bookedBikes;
    int bikes;
    List<Integer> bikeList;
    GPSLocation location;
    String name;

    @Override
    public String toString() {
        return "BikeStation{" +
                "uniqueId=" + uniqueId +
                ", number=" + number +
                ", bookedBikes=" + bookedBikes +
                ", bikes=" + bikes +
                ", bikeList=" + bikeList +
                ", location=" + location +
                ", name='" + name + '\'' +
                '}';
    }
}
