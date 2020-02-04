package com.wroclawhelperf.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class UserToRegister {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private GPSLocation location;
    private boolean schedulerOn;

}
