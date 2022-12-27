package com.example.invoicepayments.services.implementations;

import com.example.invoicepayments.entities.Invoice;
import com.example.invoicepayments.entities.Payment;
import com.example.invoicepayments.entities.Status;
import com.example.invoicepayments.entities.User;
import com.example.invoicepayments.entities.enums.Mode;
import com.example.invoicepayments.entities.enums.State;
import com.example.invoicepayments.repositories.PaymentRepository;
import com.example.invoicepayments.services.interfaces.BankingService;
import com.example.invoicepayments.services.interfaces.InvoiceService;
import com.example.invoicepayments.services.interfaces.PaymentService;
import com.example.invoicepayments.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository paymentRepository;
    private InvoiceService invoiceService;
    private UserService userService;
    private BankingService bankingService;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, InvoiceService invoiceService,
                              UserService userService, BankingService bankingService) {
        this.paymentRepository = paymentRepository;
        this.invoiceService = invoiceService;
        this.bankingService = bankingService;
        this.userService = userService;
    }

    @Override
    public Payment addPayment(Long id) throws Exception {
        Invoice invoice = invoiceService.getInvoiceById(id);
        if(invoice.getUser().isBanned()) {
            throw new Exception("The user is banned! The payment cannot be created!");
        }
        Payment payment = new Payment(invoice, new Status());
        return paymentRepository.save(payment);
    }

    @Override
    public Payment updatePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElseThrow();
    }

    @Override
    public void deletePaymentById(Long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public Payment processPayment(Long id) throws Exception {
        Payment payment = addPayment(id);
        if (payment.getInvoice().getMode() == Mode.AUTOMATIC &&
                payment.getStatus().getState() == State.UNPROCESSED) {
            payment = processPayment(payment);
        }
        return payment;
    }

    private Payment processPayment(Payment payment) {
        Payment res = bankingService.processPayment(payment);
        Status status = res.getStatus();
        switch (status.getState()) {
            case SUCCESSFUL -> payment = res;
            case WAITING_RETRY -> {
                payment = setupPaymentForRetry(res);
                if (payment.getStatus().getState() == State.WAITING_RETRY) {
                    //потрібно запланувати спробу повторного виконання оплати через день
                    //і в планувальник передати наступний метод:
                    //processPayment()
                }
            }
        }
        return payment;
    }

    private Payment setupPaymentForRetry(Payment payment){
        Status status = payment.getStatus();
        if(status.getRetries() + 1 <= Status.RETRIES_LIMIT) {
            status.setRetries(status.getRetries() + 1);
        } else {
            User user = payment.getInvoice().getUser();
            user.setBanned(true);
            userService.updateUser(user);
            status.setState(State.FAILED);
        }
        payment.setStatus(status);
        return paymentRepository.save(payment);
    }

}
