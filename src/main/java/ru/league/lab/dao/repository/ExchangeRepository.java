package ru.league.lab.dao.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ru.league.lab.dao.entity.Exchange;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

    List<Exchange> findByCodeStartsWith(String firstLetters);

    @Query("select e from Exchange e where e.code = :code")
    List<Exchange> findAllByCodeQuery(@Param("code") String name);

    @Query(value = "select * from lab.exchange_rates where currency_code = ? and cost = ?", nativeQuery = true)
    List<Exchange> findAllByCodeAndCostNative(String name, BigDecimal cost);
}
