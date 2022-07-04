package com.company.candyshop.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "FLOW_SHEET", indexes = {
        @Index(name = "IDX_FLOWSHEET_CANDY_SHOP_ID", columnList = "CANDY_SHOP_ID")
})
@Entity
public class FlowSheet {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "CONFECTIONERY_NAME", nullable = false)
    @NotNull
    private String confectioneryName;

    @OneToMany(mappedBy = "flowSheet")
    private List<Ingredient> ingredientList;

    @JoinColumn(name = "CANDY_SHOP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CandyShop candyShop;

    public CandyShop getCandyShop() {
        return candyShop;
    }

    public void setCandyShop(CandyShop candyShop) {
        this.candyShop = candyShop;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public void setConfectioneryName(String confectioneryName) {
        this.confectioneryName = confectioneryName;
    }

    public String getConfectioneryName() {
        return confectioneryName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}