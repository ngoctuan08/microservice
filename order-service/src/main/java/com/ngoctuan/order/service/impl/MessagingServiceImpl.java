package com.ngoctuan.order.service.impl;

import com.google.gson.Gson;
import com.ngoctuan.data.entity.Order;
import com.ngoctuan.order.service.MessagingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessagingServiceImpl implements MessagingService {

    private final Gson gson;

    private final MessageChannel messageChannel;

    @Override
    public void fireOrderCreatedEvent(Order order) {
        log.info("Fire order created event for {}", gson.toJson(order));
        messageChannel.send(MessageBuilder.withPayload(order).build());
    }
}
