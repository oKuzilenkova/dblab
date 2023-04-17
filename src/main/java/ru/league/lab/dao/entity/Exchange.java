package ru.league.lab.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
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

