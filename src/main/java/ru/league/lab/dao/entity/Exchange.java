package ru.league.lab.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="exchange_rates", schema = "lab")
@NamedNativeQueries({
        @NamedNativeQuery(name = "usefulNativeQuery", query = "select * from lab.exchange_rates;")
})
@NamedQueries({
        @NamedQuery(name = "usefulQuery", query = "select e from Exchange e")
})
public class Exchange implements Serializable {

    @Id
    @Column
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "currency_code")
    private String code;

    @Column
    private BigDecimal cost;

   /* @ManyToOne
    @JoinColumn()
    private Country country;
*/
    @Override
    public String toString(){
        return code + ": " + cost + "\'";
    }
}

