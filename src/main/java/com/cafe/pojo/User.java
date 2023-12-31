package com.cafe.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    private Integer  userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String phone;
    private String role;
    }

