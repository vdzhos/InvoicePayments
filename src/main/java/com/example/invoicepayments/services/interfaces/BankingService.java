package com.example.invoicepayments.services.interfaces;

import com.example.invoicepayments.entities.Payment;

public interface BankingService {

    Payment processPayment(Payment payment);

}
