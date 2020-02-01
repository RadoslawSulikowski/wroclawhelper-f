package com.wroclawhelperf.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private GPSLocation location;
    private boolean schedulerOn;

    @Override
    public String toString() {
        return "User{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", location=" + location +
                ", schedulerOn=" + schedulerOn +
                '}';
    }
}
