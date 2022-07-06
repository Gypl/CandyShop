package com.company.candyshop.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JmixEntity
@Table(name = "ORDERED_CONFECTIONERY", indexes = {
        @Index(name = "IDX_ORDEREDCONFECTIONERY", columnList = "ORDER_ID")
})
@Entity
public class OrderedConfectionery {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "CONFECTIONERY_NAME", nullable = false)
    @NotNull
    private String confectioneryName;

    @Column(name = "NUMBER_", nullable = false)
    @NotNull
    private Integer number;
    @JoinColumn(name = "ORDER_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getConfectioneryName() {
        return confectioneryName;
    }

    public void setConfectioneryName(String confectioneryName) {
        this.confectioneryName = confectioneryName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}