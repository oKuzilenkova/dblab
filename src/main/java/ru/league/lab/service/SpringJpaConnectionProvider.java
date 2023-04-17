package ru.league.lab.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import ru.league.lab.dao.entity.Exchange;
import ru.league.lab.dao.repository.ExchangeRepository;

public class SpringJpaConnectionProvider {

    @Autowired
    private ExchangeRepository repository;

    @PostConstruct
    public void printData() {
        List<Exchange> resList = repository.findByCodeStartsWith("U");

        System.out.println("SpringJpaConnectionProvider run");
        System.out.println(resList);
    }
}
