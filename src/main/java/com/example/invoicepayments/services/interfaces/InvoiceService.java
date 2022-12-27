package com.example.invoicepayments.services.interfaces;

import com.example.invoicepayments.entities.Invoice;

public interface InvoiceService {

    Invoice addInvoice(Invoice invoice);
    Invoice updateInvoice(Invoice invoice);
    Invoice getInvoiceById(Long id);
    void deleteInvoiceById(Long id);

}
