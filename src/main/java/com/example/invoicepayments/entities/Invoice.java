package com.example.invoicepayments.entities;

import com.example.invoicepayments.entities.enums.Mode;
import com.example.invoicepayments.entities.enums.Period;
import com.example.invoicepayments.entities.enums.Mode;
import com.example.invoicepayments.entities.enums.Period;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    @Id
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Tariff tariff;
    private Period period;
    private Mode mode;
    private Date date;

}


