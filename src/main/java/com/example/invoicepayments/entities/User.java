package com.example.invoicepayments.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private String postalCode;

    private boolean isBanned;

    @OneToMany
    private List<Invoice> invoices;

}
