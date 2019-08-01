package com.art.experience.dev.model;

import org.springframework.hateoas.core.Relation;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "barbers")
@Relation(value = "barber", collectionRelation = "barbers")
public class Barber implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "barber_id")
    private Long barberId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "name")
    private String name;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "cel")
    private Integer cel;
    @Column(name = "amount_of_cuts")
    private Long amountCuts;
    @Column(name = "amount_of_clients")
    private String clientsBarber;
    @Column(name = "start_date")
    private Instant startDate;
    @Column(name = "end_date")
    private Instant endDate;
    @Column(name = "rate_of_barber")
    private String rateOfBarber;
    @Column(name = "count_of_reserves_day")
    private String reservesByDay;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public Long getBarberId() {
        return barberId;
    }

    public void setBarberId(Long barberId) {
        this.barberId = barberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCel() {
        return cel;
    }

    public void setCel(Integer cel) {
        this.cel = cel;
    }

    public Long getAmountCuts() {
        return amountCuts;
    }

    public void setAmountCuts(Long amountCuts) {
        this.amountCuts = amountCuts;
    }

    public String getClientsBarber() {
        return clientsBarber;
    }

    public void setClientsBarber(String clientsBarber) {
        this.clientsBarber = clientsBarber;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public String getRateOfBarber() {
        return rateOfBarber;
    }

    public void setRateOfBarber(String rateOfBarber) {
        this.rateOfBarber = rateOfBarber;
    }

    public String getReservesByDay() {
        return reservesByDay;
    }

    public void setReservesByDay(String reservesByDay) {
        this.reservesByDay = reservesByDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Barber barber = (Barber) o;
        return barberId.equals(barber.barberId) &&
                name.equals(barber.name) &&
                username.equals(barber.username) &&
                password.equals(barber.password) &&
                email.equals(barber.email) &&
                cel.equals(barber.cel) &&
                amountCuts.equals(barber.amountCuts) &&
                clientsBarber.equals(barber.clientsBarber) &&
                startDate.equals(barber.startDate) &&
                endDate.equals(barber.endDate) &&
                rateOfBarber.equals(barber.rateOfBarber) &&
                reservesByDay.equals(barber.reservesByDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barberId, name, username, password, email, cel, amountCuts, clientsBarber, startDate, endDate, rateOfBarber, reservesByDay);
    }
}



