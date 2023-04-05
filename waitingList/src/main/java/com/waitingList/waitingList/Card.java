package com.waitingList.waitingList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name="Cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String firstname;
    String lastname;
    String illness;
    Integer priority;
    Long arrivalTime;

    // default constructor
    public Card(){}

    public Card(Long id, String firstname, String lastname, String illness, Integer priority) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.illness = illness;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getIllness() {
        return illness;
    }

    public Integer getPriority() {
        return priority;
    }



    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Long getArrivalTime() {
        return arrivalTime;
    }
}
