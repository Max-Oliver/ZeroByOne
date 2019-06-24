package com.art.experience.dev.model;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Table(name = "usuarios")
@Entity
public class Usuarios {

    @Id
    @GeneratedValue
    @Column(name = "id_user")
    private Long id;
    @Column(name = "username")
    private String username;
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
        Usuarios usuarios = (Usuarios) o;
        return status == usuarios.status &&
                id.equals(usuarios.id) &&
                username.equals(usuarios.username) &&
                password.equals(usuarios.password) &&
                fullname.equals(usuarios.fullname) &&
                email.equals(usuarios.email) &&
                cel.equals(usuarios.cel) &&
                Objects.equals(createOn, usuarios.createOn) &&
                Objects.equals(deleteOn, usuarios.deleteOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, fullname, email, cel, createOn, deleteOn, status);
    }
}
