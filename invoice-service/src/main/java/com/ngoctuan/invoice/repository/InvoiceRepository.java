package com.ngoctuan.invoice.repository;

import com.ngoctuan.data.entity.Invoice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;

public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Long>, CrudRepository<Invoice, Long> {

}
