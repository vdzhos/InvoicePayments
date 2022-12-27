package com.example.invoicepayments.repositories;

import com.example.invoicepayments.entities.Tariff;
import com.example.invoicepayments.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TariffRepository extends CrudRepository<Tariff, Long> {

}
