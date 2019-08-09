package com.art.experience.dev.model;

import org.springframework.hateoas.core.Relation;
import javax.persistence.*;
import java.time.*;
import java.util.Objects;

@Entity
@Table(name = "barbers")
@Relation(value = "barber", collectionRelation = "barbers")
public class Barber {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "barber_sequence", allocationSize = 1)
    @Column(name = "barber_id")
    private Long barberId;
    @Column(name= "user_id")
    private Long userId;

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
    @Column(name = "amount_of_reserves_day")
    private String amountOfReservesByDay;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getAmountOfreservesByDay() {
        return amountOfReservesByDay;
    }

    public void setAmountOfreservesByDay(String amountOfreservesByDay) {
        this.amountOfReservesByDay = amountOfreservesByDay;
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
                amountOfReservesByDay.equals(barber.amountOfReservesByDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barberId, name, username, password, email, cel, amountCuts, clientsBarber, startDate, endDate, rateOfBarber, amountOfReservesByDay);
    }
}



