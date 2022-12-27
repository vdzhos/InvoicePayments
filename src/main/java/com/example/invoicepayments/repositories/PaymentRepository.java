package com.example.invoicepayments.repositories;

import com.example.invoicepayments.entities.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
