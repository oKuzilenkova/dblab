package ru.league.lab.service;

import java.util.List;

import org.springframework.stereotype.Component;

import ru.league.lab.dao.entity.Exchange;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Component
public class EntityManagerJdbcConnectionProvider {

    @PersistenceContext
    EntityManager em;

    public void printData() {
        //String sql = "select e from Exchange e where e.country.name like ?1 and e.code = :code";

        String sql = "select e from Exchange e where e.code like :code";
        TypedQuery<Exchange> typedQuery = em.createQuery(sql, Exchange.class);
        //typedQuery.setParameter(1, "USA");
        typedQuery.setParameter("code", "U%");

   /*   String sqlN = "select * from lab.exchange_rates where currency_code like ?";
        em.createNativeQuery(sqlN);*/

        List<Exchange> resList = typedQuery.getResultList();

        System.out.println("EntityManagerJdbcConnectionProvider run");
        System.out.println(resList);
    }
}
