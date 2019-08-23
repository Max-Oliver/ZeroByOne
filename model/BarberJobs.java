package com.art.experience.dev.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.sql.Time;
import java.util.List;
import java.util.Objects;

@JsonSerialize
public class BarberJobs {

    private Long idJob;
    private Long idBarber;
    private Double price;
    private Time timeRequire;
    @JsonProperty
    private List<TypeWork> typeWork;

    public Long getIdJob() {
        return idJob;
    }

    public void setIdJob(Long idJob) {
        this.idJob = idJob;
    }

    public Long getIdBarber() {
        return idBarber;
    }

    public void setIdBarber(Long idBarber) {
        this.idBarber = idBarber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Time getTimeRequire() {
        return timeRequire;
    }

    public void setTimeRequire(Time timeRequire) {
        this.timeRequire = timeRequire;
    }

    public List<TypeWork> getTypeWork() {
        return typeWork;
    }

    public void setTypeWork(List<TypeWork> typeWork) {
        this.typeWork = typeWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BarberJobs that = (BarberJobs) o;
        return Objects.equals(idJob, that.idJob) &&
                Objects.equals(idBarber, that.idBarber) &&
                Objects.equals(price, that.price) &&
                Objects.equals(timeRequire, that.timeRequire) &&
                Objects.equals(typeWork, that.typeWork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJob, idBarber, price, timeRequire, typeWork);
    }
}
