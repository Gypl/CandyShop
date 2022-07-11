package com.company.candyshop.entity;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.CaseConversion;
import io.jmix.core.entity.annotation.ConversionType;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@JmixEntity
@Table(name = "PURCHASE", indexes = {
        @Index(name = "IDX_PURCHASE_CANDY_SHOP_ID", columnList = "CANDY_SHOP_ID")
})
@Entity
public class Purchase {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @CaseConversion(type = ConversionType.LOWER)
    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @Column(name = "AMOUNT", nullable = false)
    @NotNull
    private Double amount;

    @Column(name = "DIMENSION", nullable = false)
    @NotNull
    private String dimension;

    @JoinColumn(name = "CANDY_SHOP_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private CandyShop candyShop;

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

    public CandyShop getCandyShop() {
        return candyShop;
    }

    public void setCandyShop(CandyShop candyShop) {
        this.candyShop = candyShop;
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