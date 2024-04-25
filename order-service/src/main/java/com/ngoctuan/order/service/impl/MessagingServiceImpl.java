package com.ngoctuan.order.service.impl;

import com.google.gson.Gson;
import com.ngoctuan.data.entity.Order;
import com.ngoctuan.order.service.MessagingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessagingServiceImpl implements MessagingService {

    @Autowired
    private Gson gson;

    private final KafkaTemplate<String, Order> kafkaTemplate;

    public MessagingServiceImpl(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void fireOrderCreatedEvent(Order order) {
        log.info("Fire order created event for {}", gson.toJson(order));
        kafkaTemplate.send("order", order.getId() + "created", order);
    }
}
