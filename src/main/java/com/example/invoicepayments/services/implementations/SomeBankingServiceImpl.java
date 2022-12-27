package com.example.invoicepayments.services.implementations;

import com.example.invoicepayments.entities.Payment;
import com.example.invoicepayments.entities.Status;
import com.example.invoicepayments.entities.enums.State;
import com.example.invoicepayments.services.interfaces.BankingService;
import org.springframework.stereotype.Service;

@Service
public class SomeBankingServiceImpl implements BankingService {

    @Override
    public Payment processPayment(Payment payment) {
        //Тут необхідно провести оплату, за допомогою апі іншої платформи, яку ми хочемо підтримувати
        boolean paymentSuccessful = otherApiCallToProcessPayment(payment);
        Status status = payment.getStatus();
        if(paymentSuccessful) {
            status.setState(State.SUCCESSFUL);
            payment.setStatus(status);
        } else {
            status.setState(State.WAITING_RETRY);
            payment.setStatus(status);
        }
        return payment;
    }

    private boolean otherApiCallToProcessPayment(Payment payment){
        return true;
    }

}
