package com.example.invoicepayments.services.implementations;

import com.example.invoicepayments.entities.Tariff;
import com.example.invoicepayments.entities.User;
import com.example.invoicepayments.repositories.TariffRepository;
import com.example.invoicepayments.repositories.UserRepository;
import com.example.invoicepayments.services.interfaces.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TariffServiceImpl implements TariffService {

    private TariffRepository tariffRepository;

    @Autowired
    public TariffServiceImpl(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    @Override
    public Tariff addTariff(Tariff tariff) {
        return tariffRepository.save(tariff);
    }

    @Override
    public Tariff updateTariff(Tariff tariff) {
        return tariffRepository.save(tariff);
    }

    @Override
    public Tariff getTariffById(Long id) {
        return tariffRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteTariffById(Long id) {
        tariffRepository.deleteById(id);
    }

}
