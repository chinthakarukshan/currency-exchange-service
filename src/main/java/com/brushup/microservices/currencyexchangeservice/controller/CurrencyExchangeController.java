package com.brushup.microservices.currencyexchangeservice.controller;

import com.brushup.microservices.currencyexchangeservice.dto.CurrencyExchange;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getExchangeValue(@PathVariable String from, @PathVariable String to) {
        return new CurrencyExchange(1000,"USD","LKR", BigDecimal.valueOf(395));
    }
}
