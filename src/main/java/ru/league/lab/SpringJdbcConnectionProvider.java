package ru.league.lab;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ru.league.lab.dao.Exchange;

public class SpringJdbcConnectionProvider {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void printData() {
        String sql = "select * from lab.exchange_rates where currency_code like ?";

        ExchangeMapper mapper = new ExchangeMapper();
        List<Exchange> resList = jdbcTemplate.query(sql, mapper, "F%");

        System.out.println("SpringJdbcConnectionProvider run");
        System.out.println(resList);
    }

    private static class ExchangeMapper implements RowMapper<Exchange>{

        @Override
        public Exchange mapRow(ResultSet rs, int i) throws SQLException {
            Exchange exchange = new Exchange();
            exchange.setCode(rs.getString(2));
            exchange.setCost(rs.getBigDecimal("cost"));
            return exchange;
        }
    }
}
