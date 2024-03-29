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
@Table(name = "CONFECTIONERY", indexes = {
        @Index(name = "IDX_CONFECTIONERY", columnList = "CANDY_SHOP_ID")
})
@Entity
public class Confectionery {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CONFECRIONERY_NAME_ID", nullable = false)
    @NotNull
    @InstanceName
    private FlowSheet confectioneryName;

    @Column(name = "NUMBER_", nullable = false)
    @NotNull
    private Integer number;

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

    public void setConfectioneryName(FlowSheet confectioneryName) {
        this.confectioneryName = confectioneryName;
    }

    public FlowSheet getConfectioneryName() {
        return confectioneryName;
    }

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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}