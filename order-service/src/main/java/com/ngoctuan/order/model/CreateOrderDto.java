package com.ngoctuan.order.model;

import com.ngoctuan.data.entity.Address;
import com.ngoctuan.data.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDto {

    private Customer customer;

    private Address shippingAddress;

    private Address billingAddress;

    private List<ItemDto> itemDtos;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ItemDto {
        private String name;
        private long price;
        private long quantity;
    }
}
