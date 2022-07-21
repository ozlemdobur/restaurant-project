package com.restaurant.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class TableRestaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long tableNumber;
    private Long tableSize;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    //private LocalDate tableReserveStartDate;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    //private LocalTime tableReserveStartTime;
   // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    //private LocalTime tableReserveEndTime;


    public TableRestaurant() {
    }

    public TableRestaurant(Long id, Long tableNumber, Long tableSize) {
        this.id = id;
        this.tableNumber = tableNumber;
        this.tableSize = tableSize;

    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Long tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Long getTableSize() {
        return tableSize;
    }

    public void setTableSize(Long tableSize) {
        this.tableSize = tableSize;
    }

    @Override
    public String toString() {
        return "TableRestaurant{" +
                "id=" + id +
                ", tableNumber=" + tableNumber +
                ", tableSize=" + tableSize +
                '}';

    }
}