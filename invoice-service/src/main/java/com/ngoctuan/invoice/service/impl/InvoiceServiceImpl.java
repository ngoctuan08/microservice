package com.ngoctuan.invoice.service.impl;

import com.ngoctuan.data.entity.Invoice;
import com.ngoctuan.invoice.repository.InvoiceRepository;
import com.ngoctuan.invoice.service.InvoiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Transactional
	public void generateInvoice(Invoice invoice) {
		if (invoiceRepository.existsById(invoice.getId())) {
			log.info("Invoice id {} already exists - ignored", invoice.getId());
		} else {
			invoiceRepository.save(invoice);
		}
	}

	@Override
	public Invoice findById(long id) {
		return invoiceRepository.findById(id).orElse(null);
	}

	@Override
	public List<Invoice> findAll() {
		return (List<Invoice>) invoiceRepository.findAll();
	}

}
