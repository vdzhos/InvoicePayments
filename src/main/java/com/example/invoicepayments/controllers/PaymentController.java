package com.example.invoicepayments.controllers;

import com.example.invoicepayments.entities.Payment;
import com.example.invoicepayments.services.interfaces.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/payments")
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/add/{id}")
    public Payment addPayment(@PathVariable(value = "id") Long id) throws Exception {
        return paymentService.processPayment(id);
    }

}
