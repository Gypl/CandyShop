package com.company.candyshop.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "ORDER_", indexes = {
        @Index(name = "IDX_ORDER_CANDY_SHOP_ID", columnList = "CANDY_SHOP_ID")
})
@Entity(name = "Order_")
public class Order {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "ORDER_NUMBER", nullable = false, unique = true)
    @NotNull
    private Long orderNumber;

    @Composition
    @OneToMany(mappedBy = "order")
    private List<OrderedConfectionery> orederedConfectioneries;

    @Column(name = "START_READY")
    private Boolean startReady;

    @Column(name = "SERVE_READY")
    private Boolean serveReady;
    @JoinColumn(name = "CANDY_SHOP_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private CandyShop candyShop;

    public CandyShop getCandyShop() {
        return candyShop;
    }

    public void setCandyShop(CandyShop candyShop) {
        this.candyShop = candyShop;
    }

    public List<OrderedConfectionery> getOrederedConfectioneries() {
        return orederedConfectioneries;
    }

    public void setOrederedConfectioneries(List<OrderedConfectionery> orederedConfectioneries) {
        this.orederedConfectioneries = orederedConfectioneries;
    }

    public Boolean getServeReady() {
        return serveReady;
    }

    public Boolean getStartReady() {
        return startReady;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}