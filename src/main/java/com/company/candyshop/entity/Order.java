package com.company.candyshop.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @Column(name = "ORDER_NUMBER", nullable = false)
    @NotNull
    private Long orderNumber;

    @Column(name = "CONFECTIONERY_NAME", nullable = false)
    @NotNull
    private String confectioneryName;

    @Column(name = "START_READY")
    private Boolean startReady;

    @Column(name = "SERVR_READY")
    private Boolean servrReady;

    @JoinColumn(name = "CANDY_SHOP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CandyShop candyShop;

    public CandyShop getCandyShop() {
        return candyShop;
    }

    public void setCandyShop(CandyShop candyShop) {
        this.candyShop = candyShop;
    }

    public void setStartReady(Boolean startReady) {
        this.startReady = startReady;
    }

    public Boolean getServrReady() {
        return servrReady;
    }

    public void setServrReady(Boolean servrReady) {
        this.servrReady = servrReady;
    }

    public Boolean getStartReady() {
        return startReady;
    }

    public String getConfectioneryName() {
        return confectioneryName;
    }

    public void setConfectioneryName(String confectioneryName) {
        this.confectioneryName = confectioneryName;
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