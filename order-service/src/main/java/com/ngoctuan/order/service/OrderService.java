package com.ngoctuan.order.service;

import com.ngoctuan.data.entity.Order;
import com.ngoctuan.order.model.CreateOrderDto;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    Order findById(Long id);

    void deleteById(Long id);

    Order createOrder(CreateOrderDto createOrderDto);

//    double getPrice(long orderId);
}
