package com.ngoctuan.shipping.service.impl;

import com.ngoctuan.data.entity.Shipment;
import com.ngoctuan.shipping.repository.ShipmentRepository;
import com.ngoctuan.shipping.service.ShipmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ShipmentServiceImpl implements ShipmentService {

	private ShipmentRepository shipmentRepository;

	public ShipmentServiceImpl(ShipmentRepository shipmentRepository) {
		super();
		this.shipmentRepository = shipmentRepository;
	}

	@Transactional
	public void ship(Shipment shipment) {
		if (shipmentRepository.existsById(shipment.getId())) {
			log.info("Shipment id {} already exists - ignored", shipment.getId());
		} else {
			shipmentRepository.save(shipment);
		}
	}

	@Override
	public Shipment findById(long id) {
		return shipmentRepository.findById(id).orElse(null);
	}

	@Override
	public List<Shipment> findAll() {
		return (List<Shipment>) shipmentRepository.findAll();
	}

}
