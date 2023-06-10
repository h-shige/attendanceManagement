package com.example.ads.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginUser {

    private Long id;

    private String userName;

    private String password;

    private String authorityName;

}