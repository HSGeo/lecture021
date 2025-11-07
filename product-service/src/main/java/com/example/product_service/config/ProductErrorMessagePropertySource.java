package com.example.product_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;

@Configuration
@PropertySource(value = "classpath*:product-error-message.properties") //특정 properties을 가져올때 사용 @PropertySource와 @Value은 항상 같이 다님
@Getter
public class ProductErrorMessagePropertySource {
    @Value("${error.message.productNotFound}")
    private String productNotFoundMessage;
}