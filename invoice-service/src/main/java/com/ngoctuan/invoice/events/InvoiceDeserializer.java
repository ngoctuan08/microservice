package com.ngoctuan.invoice.events;

import com.ngoctuan.data.entity.Invoice;
import org.springframework.kafka.support.serializer.JsonDeserializer;

public class InvoiceDeserializer extends JsonDeserializer<Invoice> {

	public InvoiceDeserializer() {
		super(Invoice.class);
	}

}
