package ru.league.lab.dao;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Exchange {
    private String code;
    private BigDecimal cost;

    @Override
    public String toString(){
        return code + ": " + cost + "\'";
    }
}

