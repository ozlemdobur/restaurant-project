package com.restaurant.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
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
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private LocalDate date;

   // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime time;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime endTime;

    private Long howManyPeople;
    private boolean isBabyChair;
    private Long tableId;

    //@ManyToOne
//    @JoinColumn( name="tableId")
//    @JoinTable(name="reservation_dinner_table")

//    @JoinTable(name="reservation_dinner_table",
//            joinColumns = @JoinColumn( name="reservation_id"),
//            inverseJoinColumns = @JoinColumn( name="table_id"))
    //private TableRestaurant tableRestaurant;

    @ManyToOne
//    @JoinColumn( name="tableId")
//    @JoinTable(name="reservation_dinner_table")

//    @JoinTable(name="reservation_dinner_table",
//            joinColumns = @JoinColumn( name="reservation_id"),
//            inverseJoinColumns = @JoinColumn( name="table_id"))
    private TableRestaurant tableRestaurant;

    public Reservation() {
    }



    public Reservation(Long id, String firstName, String lastName, String email, String phone, LocalDate date, LocalTime time, LocalTime endTime, Long howManyPeople, boolean isBabyChair, Long tableId) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.date = date;
        this.time = time;
        this.endTime = endTime;
        this.howManyPeople = howManyPeople;
        this.isBabyChair = isBabyChair;

        this.tableId = tableId;

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
                ", endTime=" + endTime +
                ", howManyPeople=" + howManyPeople +
                ", isBabyChair=" + isBabyChair +

                ", tableId=" + tableId +
                '}';
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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
    public Long getHowManyPeople() {
        return howManyPeople;
    }
    public void setHowManyPeople(Long howManyPeople) {
        this.howManyPeople = howManyPeople;
    }
    public boolean isBabyChair() {
        return isBabyChair;
    }
    public void setBabyChair(boolean babyChair) {
        this.isBabyChair = babyChair;
    }


    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }
}