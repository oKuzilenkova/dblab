package ru.league.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.league.lab.config.AppConfig;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws Exception {
       //NativeJdbcConnectionProvider.printData();
        //SpringApplication.run(Main.class, args);

       ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    }
}
