package com.wroclawhelperf.domain;

import lombok.Getter;

@Getter
public class UserToVerify {
    private String username;
    private String password;

    public UserToVerify(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
