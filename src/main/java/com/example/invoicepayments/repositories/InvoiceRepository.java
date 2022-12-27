package com.example.invoicepayments.repositories;

import com.example.invoicepayments.entities.Invoice;
import com.example.invoicepayments.entities.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

}
