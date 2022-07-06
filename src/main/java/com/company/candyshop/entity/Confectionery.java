package com.company.candyshop.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JmixEntity
@Table(name = "CONFECTIONERY", indexes = {
        @Index(name = "IDX_CONFECTIONERY", columnList = "CANDY_SHOP_ID")
})
@Entity
public class Confectionery {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "CONFECRIONERY_NAME", nullable = false)
    @NotNull
    private String confecrioneryName;

    @Column(name = "NUMBER_", nullable = false)
    @NotNull
    private Integer number;
    @JoinColumn(name = "CANDY_SHOP_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private CandyShop candyShop;

    public CandyShop getCandyShop() {
        return candyShop;
    }

    public void setCandyShop(CandyShop candyShop) {
        this.candyShop = candyShop;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getConfecrioneryName() {
        return confecrioneryName;
    }

    public void setConfecrioneryName(String confecrioneryName) {
        this.confecrioneryName = confecrioneryName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}