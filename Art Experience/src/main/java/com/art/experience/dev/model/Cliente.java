package com.art.experience.dev.model;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Table(name = "client")
@Entity
public class Cliente {

    @Id
    @GeneratedValue()
    @Column(name= "id_client")
    private Long id;
    @Column(name= "name")
    private String name;
    @Column(name= "username")
    private String username;
    @Column(name= "password")
    private String password;
    @Column(name= "mail")
    private String mail;
    @Column(name= "cel")
    private Integer cel;
    @Column(name= "amount_of_reserves")
    private Long amountReservas;
    @Column(name= "amount_of_interactions")
    private String interactions;
    @Column(name= "date_start")
    private Instant dateStart;
    @Column(name= "date_finished")
    private Instant dateFinish;
    @Column(name= "stattus_of_client")
    private String Status;
    @Column(name= "type_of_bound_client")
    private String clientType;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getCel() {
        return cel;
    }

    public void setCel(Integer cel) {
        this.cel = cel;
    }

    public Long getAmountReservas() {
        return amountReservas;
    }

    public void setAmountReservas(Long amountReservas) {
        this.amountReservas = amountReservas;
    }

    public String getInteractions() {
        return interactions;
    }

    public void setInteractions(String interactions) {
        this.interactions = interactions;
    }

    public Instant getDateStart() {
        return dateStart;
    }

    public void setDateStart(Instant dateStart) {
        this.dateStart = dateStart;
    }

    public Instant getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Instant dateFinish) {
        this.dateFinish = dateFinish;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id.equals(cliente.id) &&
                name.equals(cliente.name) &&
                username.equals(cliente.username) &&
                password.equals(cliente.password) &&
                mail.equals(cliente.mail) &&
                cel.equals(cliente.cel) &&
                amountReservas.equals(cliente.amountReservas) &&
                interactions.equals(cliente.interactions) &&
                dateStart.equals(cliente.dateStart) &&
                dateFinish.equals(cliente.dateFinish) &&
                Status.equals(cliente.Status) &&
                clientType.equals(cliente.clientType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, username, password, mail, cel, amountReservas, interactions, dateStart, dateFinish, Status, clientType);
    }

}
