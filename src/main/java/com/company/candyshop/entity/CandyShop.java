package com.company.candyshop.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
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

    @OneToMany(mappedBy = "candyShop")
    private List<FlowSheet> flowSheetList;

    @OneToMany(mappedBy = "candyShop")
    private List<Ingredient> ingredientList;

    @OneToMany(mappedBy = "candyShop")
    private List<Confectionery> confectioneryList;

    @OneToMany(mappedBy = "candyShop")
    private List<Purchase> purchaseList;

    @OneToMany(mappedBy = "candyShop")
    private List<Order> orderList;

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }

    public List<Confectionery> getConfectioneryList() {
        return confectioneryList;
    }

    public void setConfectioneryList(List<Confectionery> confectioneryList) {
        this.confectioneryList = confectioneryList;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public List<FlowSheet> getFlowSheetList() {
        return flowSheetList;
    }

    public void setFlowSheetList(List<FlowSheet> flowSheetList) {
        this.flowSheetList = flowSheetList;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}