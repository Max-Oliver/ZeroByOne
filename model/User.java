package com.art.experience.dev.model;

import org.springframework.hateoas.core.Relation;
import javax.persistence.*;
import java.time.*;
import java.util.Objects;

@Entity
@Table(name = "users",catalog= "postgres",schema = "public")
@Relation(value = "user", collectionRelation = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user_sequence", allocationSize = 1)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "username")
    private String username;

    @Column(name= "client_id")
    private Long clientId;
    @Column(name= "barber_id")
    private Long barberId;

    @Column(name = "password")
    private String password;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "email")
    private String email;
    @Column(name = "cel_phone")
    private Integer cel;
    @Column(name = "create_on")
    private Instant createOn;
    @Column(name = "delete_on")
    private Instant deleteOn;
    @Column(name = "status")
    private boolean status;


    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getBarberId() {
        return barberId;
    }

    public void setBarberId(Long barberId) {
        this.barberId = barberId;
    }

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
                userId.equals(user.userId) &&
                username.equals(user.username) &&
                password.equals(user.password) &&
                fullName.equals(user.fullName) &&
                email.equals(user.email) &&
                cel.equals(user.cel) &&
                Objects.equals(createOn, user.createOn) &&
                Objects.equals(deleteOn, user.deleteOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password, fullName, email, cel, createOn, deleteOn, status);
    }
}
