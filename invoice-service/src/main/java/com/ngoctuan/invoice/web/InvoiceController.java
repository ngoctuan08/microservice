package com.ngoctuan.invoice.web;

import com.ngoctuan.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getInvoiceById(@PathVariable("id") long id) {
        return ResponseEntity.ok(invoiceService.findById(id));
    }

    @GetMapping("/")
    public ResponseEntity<?> getListInvoice() {
        return ResponseEntity.ok(invoiceService.findAll());
    }

}
