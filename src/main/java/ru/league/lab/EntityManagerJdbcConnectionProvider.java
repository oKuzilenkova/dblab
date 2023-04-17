package ru.league.lab;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ru.league.lab.dao.entity.Exchange;

public class EntityManagerJdbcConnectionProvider {

    @PersistenceContext
    EntityManager em;

    @PostConstruct
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
