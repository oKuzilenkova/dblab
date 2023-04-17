package ru.league.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import ru.league.lab.controller.Starter;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
        PersistenceExceptionTranslationAutoConfiguration.class})
public class Application implements CommandLineRunner {

    @Autowired
    private Starter starter;

    public static void main(final String args[]) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(final String... s) {
        starter.run();
    }

}
