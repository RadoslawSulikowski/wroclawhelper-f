package com.wroclawhelperf.domain;

import com.wroclawhelperf.encryptor.Encryptor;
import lombok.Getter;

@Getter
public class UserToVerify {
    private String username;
    private String password;

    public UserToVerify(String username, String password) {
        this.username = username;
        this.password = Encryptor.encrypt(password);
    }
}
