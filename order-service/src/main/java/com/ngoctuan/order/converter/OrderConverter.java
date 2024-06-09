package com.ngoctuan.order.converter;

import com.ngoctuan.data.entity.Order;
import com.ngoctuan.order.model.CreateOrderDto;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class OrderConverter {

    public static Order toEntity(CreateOrderDto orderDto) {

        return Order.builder()
//                .customer(orderDto.getCustomer())
//                .billingAddress(orderDto.getBillingAddress())
//                .shippingAddress(orderDto.getShippingAddress())
//                .items(items)
                .build();
    }
}
