package com.example.invoicepayments.repositories;

import com.example.invoicepayments.entities.Invoice;
import com.example.invoicepayments.entities.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

}
