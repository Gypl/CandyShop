package com.company.candyshop.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Composition;
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

    @Column(name = "CONFECTIONERY_NAME", nullable = false, unique = true)
    @NotNull
    private String confectioneryName;

    @Composition
    @OneToMany(mappedBy = "flowSheet")
    private List<Ingredient> ingredients;
    @JoinColumn(name = "CANDY_SHOP_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private CandyShop candyShop;

    public CandyShop getCandyShop() {
        return candyShop;
    }

    public void setCandyShop(CandyShop candyShop) {
        this.candyShop = candyShop;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
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