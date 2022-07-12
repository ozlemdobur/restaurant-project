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
    private LocalDate tableReserveStartDate;
    private LocalTime tableReserveStartTime;
    private LocalTime tableReserveEndTime;

    public TableRestaurant() {
    }

    public TableRestaurant(Long id, Long tableNumber, Long tableSize, LocalDate tableReserveStartDate, LocalTime tableReserveStartTime, LocalTime tableReserveEndTime) {
        this.id = id;
        this.tableNumber = tableNumber;
        this.tableSize = tableSize;
        this.tableReserveStartDate = tableReserveStartDate;
        this.tableReserveStartTime = tableReserveStartTime;
        this.tableReserveEndTime = tableReserveEndTime;
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
    public LocalDate getTableReserveStartDate() {
        return tableReserveStartDate;
    }
    public void setTableReserveStartDate(LocalDate tableReserveStartDate) {
        this.tableReserveStartDate = tableReserveStartDate;
    }
    public LocalTime getTableReserveStartTime() {
        return tableReserveStartTime;
    }
    public void setTableReserveStartTime(LocalTime tableReserveStartTime) {
        this.tableReserveStartTime = tableReserveStartTime;
    }
    public LocalTime getTableReserveEndTime() {
        return tableReserveEndTime;
    }
    public void setTableReserveEndTime(LocalTime tableReserveEndTime) {
        this.tableReserveEndTime = tableReserveEndTime;
    }
}