package com.example.order_service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateOrderDto {
    @JsonIgnore //사용자에게 데이터를 전달받지 않고, 전달해주지도 않을때 사용/ 값을 채울때는 setter로 mybatis가 채워줌
    private int id;
    
    @NotNull
    @Size(max = 20)
    private String userId;
    
    @NotNull
    @Positive
    private int productId;
    
    @NotNull
    @Positive
    private int totalAmount;
}
