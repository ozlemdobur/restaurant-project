package com.restaurant.service;

import com.restaurant.model.TableRestaurant;
import java.util.List;
import java.util.Optional;

public interface TableRestaurantService {
    public Iterable<TableRestaurant> findAll();
    public void save(TableRestaurant tableRestaurant);
    public List <TableRestaurant> findByEmptyTables();
    public void deleteById(Long id);
    Optional<TableRestaurant> getFreeTable(Long howManyPeople, String date, String time);
}
