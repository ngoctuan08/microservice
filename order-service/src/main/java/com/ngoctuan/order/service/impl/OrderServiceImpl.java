package com.ngoctuan.order.service.impl;

import com.ngoctuan.data.entity.Order;
import com.ngoctuan.order.converter.OrderConverter;
import com.ngoctuan.order.model.CreateOrderDto;
import com.ngoctuan.order.repository.OrderRepository;
import com.ngoctuan.order.service.MessagingService;
import com.ngoctuan.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MessagingService messagingService;

    @Override
    public List<Order> findAll() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    public Order createOrder(CreateOrderDto createOrderDto) {
        if (createOrderDto.getItemDtos().isEmpty()) {
            throw new IllegalArgumentException("No order lines!");
        }

        List<CreateOrderDto.ItemDto> itemDtos = createOrderDto.getItemDtos();

//        List<Item> items = itemDtos.stream().map(itemDto ->
//                Item.builder()
//                        .name(itemDto.getName())
//                        .price(itemDto.getPrice())
//                        .quantity((int) itemDto.getQuantity())
//                        .build()).toList();

        Order result = orderRepository.save(OrderConverter.toEntity(createOrderDto));
        messagingService.fireOrderCreatedEvent(result);
        return result;
    }

//    public double getPrice(long orderId) {
//        return orderRepository.findById(orderId).get().totalPrice();
//    }
}
