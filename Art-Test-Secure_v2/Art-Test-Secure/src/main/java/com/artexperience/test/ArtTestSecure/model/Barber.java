package com.artexperience.test.ArtTestSecure.model;

//import org.springframework.hateoas.server.core.Relation;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "barber")
//@Relation(value = "barber", collectionRelation = "barbers")
@Access(AccessType.FIELD)
public class Barber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_barber")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;

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
    @Column(name= "amount_of_cuts")
    private Long amountCuts;
    @Column(name= "amount_of_clients")
    private String clientsBarber;
    @Column(name= "date_start")
    private Instant dateStart;
    @Column(name= "date_finished")
    private Instant dateFinish;
    @Column(name= "rate_of_barber")
    private String rateOfBarber;
    @Column(name= "count_of_reserves_day")
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
        return id.equals(barber.id) &&
                name.equals(barber.name) &&
                username.equals(barber.username) &&
                password.equals(barber.password) &&
                mail.equals(barber.mail) &&
                cel.equals(barber.cel) &&
                amountCuts.equals(barber.amountCuts) &&
                clientsBarber.equals(barber.clientsBarber) &&
                dateStart.equals(barber.dateStart) &&
                dateFinish.equals(barber.dateFinish) &&
                rateOfBarber.equals(barber.rateOfBarber) &&
                reservesByDay.equals(barber.reservesByDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, username, password, mail, cel, amountCuts, clientsBarber, dateStart, dateFinish, rateOfBarber, reservesByDay);
    }
}



