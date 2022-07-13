package com.restaurant.service;

import com.restaurant.model.Reservation;
import com.restaurant.model.TableRestaurant;

import java.util.Optional;

public interface TableRestaurantService {
    public Iterable<TableRestaurant> findAll();
    public void save(TableRestaurant tableRestaurant);
    //public List <TableRestaurant> findByEmptyTables();
    //public Optional<TableRestaurant> makeControlFreeTable(Long howManyPeople, LocalDate date, LocalTime time);
    public void deleteById(Long id);
    //Optional<Reservation> getFreeTable(Long howManyPeople, String date, String time);
    //public void saveWithOptional(Optional<TableRestaurant> tableRestaurant);
}
