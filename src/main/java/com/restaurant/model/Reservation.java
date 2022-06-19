package com.restaurant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity()
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate date;
    private LocalTime time;
    private int howManyPeople;
    private boolean isBabyChair;

    public Reservation() {
    }

    public Reservation(long id, String firstName, String lastName, String email, String phone, LocalDate date,LocalTime time, int howManyPeople, boolean isBabyChair) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.date = date;
        this.time = time;
        this.howManyPeople = howManyPeople;
        this.isBabyChair = isBabyChair;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", howManyPeople=" + howManyPeople +
                ", isBabyChair=" + isBabyChair +
                '}';
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalTime getTime() {
        return time;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }
    public int getHowManyPeople() {
        return howManyPeople;
    }
    public void setHowManyPeople(int howManyPeople) {
        this.howManyPeople = howManyPeople;
    }
    public boolean isBabyChair() {
        return isBabyChair;
    }
    public void setBabyChair(boolean babyChair) {
        this.isBabyChair = babyChair;

    }
}