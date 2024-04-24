package com.ngoctuan.shipping.events;

import com.ngoctuan.data.entity.Shipment;
import com.ngoctuan.shipping.service.impl.ShipmentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderKafkaListener {

	private ShipmentServiceImpl shipmentService;

	public OrderKafkaListener(ShipmentServiceImpl shipmentService) {
		super();
		this.shipmentService = shipmentService;
	}

	@KafkaListener(topics = "order")
	public void order(Shipment shipment, Acknowledgment acknowledgment) {
		log.info("Received shipment {}", shipment.getId());
		shipmentService.ship(shipment);
		acknowledgment.acknowledge();
	}

}
