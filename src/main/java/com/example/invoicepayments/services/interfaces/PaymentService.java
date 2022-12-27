package com.example.invoicepayments.services.interfaces;

import com.example.invoicepayments.entities.Payment;

public interface PaymentService {

    Payment addPayment(Long id) throws Exception;
    Payment updatePayment(Payment payment);
    Payment getPaymentById(Long id);
    void deletePaymentById(Long id);
    Payment processPayment(Long id) throws Exception;

}
