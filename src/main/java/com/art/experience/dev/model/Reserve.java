package com.art.experience.dev.model;

import org.springframework.hateoas.core.Relation;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "reserves")
@Relation(value = "reserve", collectionRelation = "reserves")
public class Reserve implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserve_id")
    private Long reserve_id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    private Barber barberId;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    private Client clientId;

    @Column(name = "date_reserve")
    private Date dateReserve;

    @Column(name = "delete_on")
    private Instant deleteOn;
    @Column(name = "create_on")
    private Instant createOn;

    @Column(name = "type_work")
    private TypeWork workToDo;

    @Column(name = "price")
    private Double price;


    public Instant getDeleteOn() {
        return deleteOn;
    }

    public void setDeleteOn(Instant deleteOn) {
        this.deleteOn = deleteOn;
    }

    public Long getReserve_id() {
        return reserve_id;
    }

    public void setReserve_id(Long reserve_id) {
        this.reserve_id = reserve_id;
    }

    public Barber getBarberId() {
        return barberId;
    }

    public void setBarberId(Barber barberId) {
        this.barberId = barberId;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public Date getDateReserve() {
        return dateReserve;
    }

    public void setDateReserve(Date dateReserve) {
        this.dateReserve = dateReserve;
    }

    public TypeWork getWorkToDo() {
        return workToDo;
    }

    public void setWorkToDo(TypeWork workToDo) {
        this.workToDo = workToDo;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Instant getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Instant createOn) {
        this.createOn = createOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserve reserves = (Reserve) o;
        return reserve_id.equals(reserves.reserve_id) &&
                barberId.equals(reserves.barberId) &&
                clientId.equals(reserves.clientId) &&
                dateReserve.equals(reserves.dateReserve) &&
                workToDo == reserves.workToDo &&
                price.equals(reserves.price) &&
                createOn.equals(reserves.createOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reserve_id, barberId, clientId, dateReserve, workToDo, price, createOn);
    }
}

