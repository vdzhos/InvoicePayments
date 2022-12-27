package com.example.invoicepayments.services.interfaces;

import com.example.invoicepayments.entities.Tariff;

public interface TariffService {

    Tariff addTariff(Tariff tariff);
    Tariff updateTariff(Tariff tariff);
    Tariff getTariffById(Long id);
    void deleteTariffById(Long id);

}
