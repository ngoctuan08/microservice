package com.ngoctuan.order.service.impl;

import com.google.gson.Gson;
import com.ngoctuan.data.entity.Order;
import com.ngoctuan.order.service.MessagingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessagingServiceImpl implements MessagingService {

    private final Gson gson;

    private final KafkaTemplate kafkaTemplate;

    @Override
    public void fireOrderCreatedEvent(Order order) {
        log.info("Fire order created event for {}", gson.toJson(order));
        kafkaTemplate.send("order", gson.toJson(order));
    }
}
