package com.example.order_service.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.order_service.dto.CreateOrderDto;
import com.example.order_service.dto.OrderDto;

@Mapper
public interface OrderMapper {
    List<OrderDto> findUserOrders(String userId);
    OrderDto findOrderById(int id);
    
    void saveOrder(CreateOrderDto createOrderDto);
    void deleteOrderById(int id);
}
