package com.example.user_service.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class UserDto {
private String id;
    
    @JsonIgnore // 사용장에게 정보를 주지 않음
    private String password;
    
    private String username;
    private int age;
    private LocalDate createdAt;
}
