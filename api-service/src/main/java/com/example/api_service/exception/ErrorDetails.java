package com.example.api_service.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor // 정의한 필드 모든것에 대해 생성자를 만들어줌
@Getter // 만들어지면 getter로 값을 가져오기만 함
public class ErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String details;
}