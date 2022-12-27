package com.example.invoicepayments.repositories;

import com.example.invoicepayments.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
