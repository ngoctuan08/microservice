package com.ngoctuan.shipping.events;

import com.google.gson.Gson;
import com.ngoctuan.data.entity.Shipment;
import com.ngoctuan.shipping.service.ShipmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderKafkaListener {

	@Autowired
	private ShipmentService shipmentService;

	@Autowired
	private Gson gson;

	@KafkaListener(topics = "order")
	public void order(Shipment shipment, Acknowledgment acknowledgment) {
		log.info("Received shipment {}", gson.toJson(shipment));
		shipmentService.ship(shipment);
		acknowledgment.acknowledge();
	}

}
