package com.art.experience.dev.model;

import org.springframework.hateoas.core.Relation;
import javax.persistence.*;
import java.time.*;
import java.util.Objects;

@Entity
@Table(name = "clients")
@Relation(value = "client", collectionRelation = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "client_sequence", allocationSize = 1)
    @Column(name = "client_id")
    private Long clientId;
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
    @Column(name = "amount_of_reserves")
    private Long amountReservas;
    @Column(name = "amount_of_interactions")
    private String interactions;
    @Column(name = "start_date")
    private Instant startDate;
    @Column(name = "end_date")
    private Instant endDate;
    @Column(name = "status_of_client")
    private Boolean status;
    @Column(name = "type_of_bound_client")
    private String clientType;

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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
        Client client = (Client) o;
        return clientId.equals(client.clientId) &&
                name.equals(client.name) &&
                username.equals(client.username) &&
                password.equals(client.password) &&
                email.equals(client.email) &&
                cel.equals(client.cel) &&
                amountReservas.equals(client.amountReservas) &&
                interactions.equals(client.interactions) &&
                startDate.equals(client.startDate) &&
                endDate.equals(client.endDate) &&
                status.equals(client.status) &&
                clientType.equals(client.clientType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, name, username, password, email, cel, amountReservas, interactions, startDate, endDate, status, clientType);
    }

}
