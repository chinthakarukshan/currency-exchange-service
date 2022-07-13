package com.brushup.microservices.currencyexchangeservice.controller;

import com.brushup.microservices.currencyexchangeservice.dto.CurrencyExchange;
import com.brushup.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getExchangeValue(@PathVariable String from, @PathVariable String to) {
        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from,to);
        String port = environment.getProperty("local.server.port");

        if (currencyExchange == null) {
            throw new RuntimeException("Unable to find data from " + from + " to " + to);
        }

        currencyExchange.setEnvironment(port);
        return currencyExchange;
    }
}
