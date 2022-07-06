package com.company.candyshop.entity;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "CANDY_SHOP")
@Entity
public class CandyShop {
    @InstanceName
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