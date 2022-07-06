package com.company.candyshop.entity;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@JmixEntity
@Table(name = "INGREDIENT", indexes = {
        @Index(name = "IDX_INGREDIENT_FLOW_SHEET_ID", columnList = "FLOW_SHEET_ID")
})
@Entity
public class Ingredient {
    @InstanceName
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "INGREDIENT_NAME", nullable = false, unique = true)
    @NotNull
    private String ingredientName;

    @NotNull
    @Column(name = "NUMBER_", nullable = false)
    private Double amount;

    @Column(name = "DIMENSION", nullable = false)
    @NotNull
    private String dimension;

    @JoinColumn(name = "FLOW_SHEET_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private FlowSheet flowSheet;

    @DeletedBy
    @Column(name = "DELETED_BY")
    private String deletedBy;

    @DeletedDate
    @Column(name = "DELETED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}