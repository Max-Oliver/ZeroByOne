package com.art.experience.dev.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.hateoas.core.Relation;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name = "users")
@Relation(value = "user", collectionRelation = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    @JsonIgnore
    private Long id;
    @Column(name = "username")
    private String username;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "user" )
//    @JoinColumn(name = "idClient")
    private Client client;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "user" )
//    @JoinColumn(name = "idBarber")
    private Barber barber;

    @Column(name = "pass")
    private String password;
    @Column(name = "full_name")
    private String fullname;
    @Column(name = "email")
    private String email;
    @Column(name = "cel_phone")
    private AtomicInteger cel;
    @Column(name = "createOn")
    private Instant createOn;
    @Column(name = "deleteOn")
    private Instant deleteOn;
    @Column(name = "status")
    private boolean status;


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Barber getBarber() {
        return barber;
    }

    public void setBarber(Barber barber) {
        this.barber = barber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AtomicInteger getCel() {
        return cel;
    }

    public void setCel(AtomicInteger cel) {
        this.cel = cel;
    }

    public Instant getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Instant createOn) {
        this.createOn = createOn;
    }

    public Instant getDeleteOn() {
        return deleteOn;
    }

    public void setDeleteOn(Instant deleteOn) {
        this.deleteOn = deleteOn;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return status == user.status &&
                id.equals(user.id) &&
                username.equals(user.username) &&
                password.equals(user.password) &&
                fullname.equals(user.fullname) &&
                email.equals(user.email) &&
                cel.equals(user.cel) &&
                Objects.equals(createOn, user.createOn) &&
                Objects.equals(deleteOn, user.deleteOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, fullname, email, cel, createOn, deleteOn, status);
    }
}
