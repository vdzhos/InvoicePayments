package com.example.invoicepayments.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    private Long id;
    @OneToOne
    private Invoice invoice;
    private Status status;

    public Payment(Invoice invoice, Status status) {
        this.invoice = invoice;
        this.status = status;
    }

}
