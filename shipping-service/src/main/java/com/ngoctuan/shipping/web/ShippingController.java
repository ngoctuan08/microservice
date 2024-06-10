package com.ngoctuan.shipping.web;

import com.ngoctuan.shipping.service.impl.ShipmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api/v1/shipment")
public class ShippingController {

	@Autowired
	private ShipmentServiceImpl shipmentService;

	@GetMapping(value = "/{id}", produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<?> getShipmentById(@PathVariable("id") long id) {
		return ResponseEntity.ok(shipmentService.findById(id));
	}

	@GetMapping("/")
	public ResponseEntity<?> getListShipment() {
		return ResponseEntity.ok(shipmentService.findAll());
	}

}
