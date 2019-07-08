package com.artexperience.test.ArtTestSecure.model;

//import org.springframework.hateoas.server.core.Relation;
import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "client")
//@Relation(value = "client", collectionRelation = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_client")
    private Long id;
    @Column(name= "name")
    private String name;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;
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
    @Column(name= "status_of_client")
    private String Status;
    @Column(name= "type_of_bound_client")
    private String clientType;

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
        Client client = (Client) o;
        return id.equals(client.id) &&
                name.equals(client.name) &&
                username.equals(client.username) &&
                password.equals(client.password) &&
                mail.equals(client.mail) &&
                cel.equals(client.cel) &&
                amountReservas.equals(client.amountReservas) &&
                interactions.equals(client.interactions) &&
                dateStart.equals(client.dateStart) &&
                dateFinish.equals(client.dateFinish) &&
                Status.equals(client.Status) &&
                clientType.equals(client.clientType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, username, password, mail, cel, amountReservas, interactions, dateStart, dateFinish, Status, clientType);
    }

}
