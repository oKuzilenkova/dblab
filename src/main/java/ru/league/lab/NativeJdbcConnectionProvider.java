package ru.league.lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ru.league.lab.dao.Exchange;

public class NativeJdbcConnectionProvider {

    private static Connection getDbConnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/league_db", "admin", "qwerty$4");
        System.out.println("Connected to database");
        return conn;
    }

    public static void printData(){
        List<Exchange> resList = new ArrayList<>();
        String sql ="select * from lab.exchange_rates where currency_code like 'U%'";

        try (Connection conn = getDbConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){
            //ps.setString(1, "U%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Exchange exchange = new Exchange();
                exchange.setCode(rs.getString(2));
                exchange.setCost(rs.getBigDecimal("cost"));
                resList.add(exchange);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        System.out.println(resList);
    }
}
