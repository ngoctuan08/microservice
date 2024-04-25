package com.ngoctuan.order.service;

import com.ngoctuan.data.entity.Order;

public interface MessagingService {

    void fireOrderCreatedEvent(Order order);
}
