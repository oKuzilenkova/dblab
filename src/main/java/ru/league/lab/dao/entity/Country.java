package ru.league.lab.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Country {

    @Id
    private Long id;

    @Column
    private String name;
}
