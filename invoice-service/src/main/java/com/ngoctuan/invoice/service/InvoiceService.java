package com.ngoctuan.invoice.service;

import com.ngoctuan.data.entity.Invoice;

import java.util.List;

public interface InvoiceService {

    void generateInvoice(Invoice invoice);

    Invoice findById(long id);

    List<Invoice> findAll();
}
