package com.artexperience.test.ArtTestSecure.model;

import org.springframework.hateoas.server.core.Relation;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "reserva")
@Relation(value = "reserva", collectionRelation = "reservas")
public class Reserva implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_reserva")
    private Long idReserva;
    @Column(name = "id_barber")
    private Barber BarberId;
    @Column(name = "id_cliente")
    private Cliente clienteId;
    @Column(name = "date_reserva")
    private Date fechaReserva;
    @Column(name = "time_reserva")
    private Time horaReserv;
    @Column(name = "type_work")
    private TypeWork worktodo;
    @Column(name = "price")
    private Double price;
    @Column(name = "time_reserva")
    private Instant createOn;


    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public Barber getBarberId() {
        return BarberId;
    }

    public void setBarberId(Barber barberId) {
        BarberId = barberId;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Time getHoraReserv() {
        return horaReserv;
    }

    public void setHoraReserv(Time horaReserv) {
        this.horaReserv = horaReserv;
    }

    public TypeWork getWorktodo() {
        return worktodo;
    }

    public void setWorktodo(TypeWork worktodo) {
        this.worktodo = worktodo;
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
        Reserva reserves = (Reserva) o;
        return idReserva.equals(reserves.idReserva) &&
                BarberId.equals(reserves.BarberId) &&
                clienteId.equals(reserves.clienteId) &&
                fechaReserva.equals(reserves.fechaReserva) &&
                horaReserv.equals(reserves.horaReserv) &&
                worktodo == reserves.worktodo &&
                price.equals(reserves.price) &&
                createOn.equals(reserves.createOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idReserva, BarberId, clienteId, fechaReserva, horaReserv, worktodo, price, createOn);
    }
}

