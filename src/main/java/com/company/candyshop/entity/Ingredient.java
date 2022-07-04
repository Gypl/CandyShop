package com.company.candyshop.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JmixEntity
@Table(name = "INGREDIENT", indexes = {
        @Index(name = "IDX_INGREDIENT_FLOW_SHEET_ID", columnList = "FLOW_SHEET_ID"),
        @Index(name = "IDX_INGREDIENT_CANDY_SHOP_ID", columnList = "CANDY_SHOP_ID")
})
@Entity
public class Ingredient {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @Column(name = "NUMBER_", nullable = false)
    @NotNull
    private Double number;

    @Column(name = "DIMENSION", nullable = false)
    @NotNull
    private String dimension;

    @JoinColumn(name = "FLOW_SHEET_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private FlowSheet flowSheet;

    @JoinColumn(name = "CANDY_SHOP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CandyShop candyShop;

    public CandyShop getCandyShop() {
        return candyShop;
    }

    public void setCandyShop(CandyShop candyShop) {
        this.candyShop = candyShop;
    }

    public FlowSheet getFlowSheet() {
        return flowSheet;
    }

    public void setFlowSheet(FlowSheet flowSheet) {
        this.flowSheet = flowSheet;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}