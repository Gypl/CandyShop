package com.company.candyshop.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "CANDY_SHOP")
@Entity
public class CandyShop {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Composition
    @OneToMany(mappedBy = "candyShop")
    private List<FlowSheet> flowSheets;

    @Composition
    @OneToMany(mappedBy = "candyShop")
    private List<Resource> resources;

    @Composition
    @OneToMany(mappedBy = "candyShop")
    private List<Confectionery> confectioneries;

    @Composition
    @OneToMany(mappedBy = "candyShop")
    private List<Purchase> purchases;

    @Composition
    @OneToMany(mappedBy = "candyShop")
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public List<Confectionery> getConfectioneries() {
        return confectioneries;
    }

    public void setConfectioneries(List<Confectionery> confectioneries) {
        this.confectioneries = confectioneries;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public List<FlowSheet> getFlowSheets() {
        return flowSheets;
    }

    public void setFlowSheets(List<FlowSheet> flowSheets) {
        this.flowSheets = flowSheets;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}