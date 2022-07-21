package com.restaurant.service;


import com.restaurant.model.Reservation;
import com.restaurant.model.TableRestaurant;
import com.restaurant.repository.ReservationRepository;

import com.restaurant.repository.TableRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.Optional;

@Service
public class TableRestaurantServiceImpl implements TableRestaurantService {


    TableRestaurantRepository tableRestaurantRepository;

    @Autowired
    private ReservationRepository reservationRepository;


    public TableRestaurantServiceImpl() {
    }

    @Autowired
    public TableRestaurantServiceImpl(TableRestaurantRepository tableRestaurantRepository) {
        this.tableRestaurantRepository = tableRestaurantRepository;
    }


    public List<TableRestaurant> findByEmptyTables() {
        Iterable<TableRestaurant> tables = tableRestaurantRepository.findAll();
        List<TableRestaurant> emptyTables = new ArrayList<>();
        return emptyTables;
    }


    @Override
    public void deleteById(Long id) {
        tableRestaurantRepository.deleteById(id);
    }

    @Override
    public void save(TableRestaurant tableRestaurant) {
         tableRestaurantRepository.save(tableRestaurant);
    }

    @Override
    public Iterable<TableRestaurant> findAll() {
        return tableRestaurantRepository.findAll();
    }


}