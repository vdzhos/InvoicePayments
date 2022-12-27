package com.example.invoicepayments.controllers;

import com.example.invoicepayments.entities.Tariff;
import com.example.invoicepayments.entities.User;
import com.example.invoicepayments.services.interfaces.TariffService;
import com.example.invoicepayments.services.interfaces.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/tariffs")
public class TariffController {

    private TariffService tariffService;

    @Autowired
    public TariffController(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @PostMapping("/add")
    public Tariff addTariff(@RequestBody Tariff tariff) {
        return tariffService.addTariff(tariff);
    }

}
