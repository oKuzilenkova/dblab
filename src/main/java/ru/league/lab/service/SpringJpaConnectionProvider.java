package ru.league.lab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.league.lab.dao.entity.Exchange;
import ru.league.lab.dao.repository.ExchangeRepository;

@Component
public class SpringJpaConnectionProvider {

    @Autowired
    private ExchangeRepository repository;


    public void printData() {
        List<Exchange> resList = repository.findByCodeStartsWith("U");

        System.out.println("SpringJpaConnectionProvider run");
        System.out.println(resList);
    }
}
