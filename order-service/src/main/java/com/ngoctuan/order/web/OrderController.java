package com.ngoctuan.order.web;

import com.ngoctuan.data.entity.Order;
import com.ngoctuan.order.model.CreateOrderDto;
import com.ngoctuan.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public ResponseEntity<?> getOrderList() {
        return ResponseEntity.ok(orderService.findAll());
    }

//    @PostMapping("/line")
//    public ResponseEntity<?> addLine(Order order, OrderLine orderLine) {
////		order.addLine(0, orderService.findAll().iterator().next());
//        return ResponseEntity.ok(order);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable("id") long id) {
        return ResponseEntity.ok(Mono.just(orderService.findById(id)));
    }

    @PostMapping("")
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderDto createOrderDto) {
        Order order = orderService.createOrder(createOrderDto);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderById(@PathVariable("id") long id) {
        orderService.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
