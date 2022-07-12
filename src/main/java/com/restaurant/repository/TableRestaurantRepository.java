package com.restaurant.repository;

import com.restaurant.model.TableRestaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TableRestaurantRepository extends CrudRepository<TableRestaurant, Long> {

    @Query(value = "SELECT tr FROM TableRestaurant  tr " +
            "WHERE tableSize >= '2' AND tableReserveStartDate = '2022-07-11' AND tableReserveEndTime <= '17:00' " +
            "ORDER BY tableSize ")
    public List<TableRestaurant> makeControlFreeTable(@Param("tableSize") Long resertableSize,
                                                      @Param("tableReserveStartDate") LocalDate tableReserveStartDate,
                                                      @Param("tableReserveStartTime") LocalTime tableReserveStartTime);


    @Query(value = "SELECT tr FROM TableRestaurant  tr " +
            "WHERE tableSize >= :tableSize AND tableReserveStartDate <= :tableReserveStartDate AND tableReserveEndTime >= :tableReserveStartTime " +
            "ORDER BY tableSize ")
    public List<TableRestaurant> getFreeTable(@Param("tableSize") Long resertableSize,
                                              @Param("tableReserveStartDate") LocalDate tableReserveStartDate,
                                              @Param("tableReserveStartTime") LocalTime tableReserveStartTime);

}