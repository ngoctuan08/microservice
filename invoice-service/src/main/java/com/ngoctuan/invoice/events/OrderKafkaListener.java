package com.ngoctuan.invoice.events;

import com.google.gson.Gson;
import com.ngoctuan.data.entity.Invoice;
import com.ngoctuan.invoice.service.InvoiceService;
import com.ngoctuan.invoice.service.impl.InvoiceServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderKafkaListener {

	@Autowired
	private InvoiceService invoiceService;

	@Autowired
	private Gson gson;

	@KafkaListener(topics = "order")
	public void order(Invoice invoice, Acknowledgment acknowledgment) {
		log.info("Received invoice {}", gson.toJson(invoice));
		invoiceService.generateInvoice(invoice);
		acknowledgment.acknowledge();
	}

}
