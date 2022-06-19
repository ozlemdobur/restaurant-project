package com.restaurant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity()
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long reservationId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate reservationDate;
    private LocalTime reservationTime;

    private int amountPerson;
    private boolean babyChair;

    public Reservation() {
    }

    public Reservation(long reservationId, String firstName, String lastName, String email, String phoneNumber, LocalDate reservationDate,LocalTime reservationTime, int amountPerson, boolean babyChair) {
        this.reservationId = reservationId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
        this.amountPerson = amountPerson;
        this.babyChair = babyChair;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", reservationDate=" + reservationDate +
                ", reservationTime=" + reservationTime +
                ", amountPerson=" + amountPerson +
                ", babyChair=" + babyChair +
                '}';
    }

    public long getReservationId() {
        return reservationId;
    }
    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
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
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public LocalDate getReservationDate() {
        return reservationDate;
    }
    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }
    public LocalTime getReservationTime() {
        return reservationTime;
    }
    public void setReservationTime(LocalTime reservationTime) {
        this.reservationTime = reservationTime;
    }
    public int getAmountPerson() {
        return amountPerson;
    }
    public void setAmountPerson(int amountPerson) {
        this.amountPerson = amountPerson;
    }
    public boolean isBabyChair() {
        return babyChair;
    }
    public void setBabyChair(boolean babyChair) {
        this.babyChair = babyChair;
    }
}