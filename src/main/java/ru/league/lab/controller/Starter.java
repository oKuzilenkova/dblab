package ru.league.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ru.league.lab.service.EntityManagerJdbcConnectionProvider;
import ru.league.lab.service.NativeJdbcConnectionProvider;
import ru.league.lab.service.SpringJdbcConnectionProvider;
import ru.league.lab.service.SpringJpaConnectionProvider;

@Controller
public class Starter {

    @Autowired
    private SpringJdbcConnectionProvider springJdbcConnectionProvider;

    @Autowired
    private NativeJdbcConnectionProvider nativeJdbcConnectionProvider;

    //=========================
    @Autowired
    private EntityManagerJdbcConnectionProvider entityManagerJdbcConnectionProvider;

    @Autowired
    private SpringJpaConnectionProvider springJpaConnectionProvider;

    public void run() {
        nativeJdbcConnectionProvider.printData();

        springJdbcConnectionProvider.printData();

        entityManagerJdbcConnectionProvider.printData();

        springJpaConnectionProvider.printData();
    }
}
