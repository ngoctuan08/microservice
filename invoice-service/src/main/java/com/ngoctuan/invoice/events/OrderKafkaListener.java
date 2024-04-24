package com.ngoctuan.invoice.events;

import com.ngoctuan.data.entity.Invoice;
import com.ngoctuan.invoice.service.impl.InvoiceServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderKafkaListener {

	private InvoiceServiceImpl invoiceService;

	public OrderKafkaListener(InvoiceServiceImpl invoiceService) {
		super();
		this.invoiceService = invoiceService;
	}

	@KafkaListener(topics = "order")
	public void order(Invoice invoice, Acknowledgment acknowledgment) {
		log.info("Received invoice {}", invoice.getId());
		invoiceService.generateInvoice(invoice);
		acknowledgment.acknowledge();
	}

}
