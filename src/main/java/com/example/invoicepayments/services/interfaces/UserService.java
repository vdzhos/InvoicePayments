package com.example.invoicepayments.services.interfaces;

import com.example.invoicepayments.entities.User;

public interface UserService {

    User addUser(User user);
    User updateUser(User user);
    User getUserById(Long id);
    void deleteUserById(Long id);

}
