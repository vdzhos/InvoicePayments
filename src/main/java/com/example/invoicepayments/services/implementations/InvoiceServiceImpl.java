package com.example.invoicepayments.services.implementations;

import com.example.invoicepayments.entities.Invoice;
import com.example.invoicepayments.repositories.InvoiceRepository;
import com.example.invoicepayments.services.interfaces.InvoiceService;
import com.example.invoicepayments.entities.Invoice;
import com.example.invoicepayments.repositories.InvoiceRepository;
import com.example.invoicepayments.services.interfaces.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Invoice addInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice updateInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteInvoiceById(Long id) {
        invoiceRepository.deleteById(id);
    }

}
