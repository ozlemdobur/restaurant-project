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


    /*    select id from Table_Restaurant where table_size>= 2 and TABLE_RESERVE_START_DATE = '2022-07-11'
        and TABLE_RESERVE_START_TIME = '10:42:25' order by table_size limit 1;*/
/*
    @Query(value = "SELECT tr FROM TableRestaurant  tr " +
            "WHERE tableSize >= '2' AND tableReserveStartDate = '2022-07-11' AND tableReserveEndTime <= '17:00' " +
            "ORDER BY tableSize ")
    public List<TableRestaurant> makeControlFreeTable(@Param("tableSize") Long resertableSize,
                                                      @Param("tableReserveStartDate") LocalDate tableReserveStartDate,
                                                      @Param("tableReserveStartTime") LocalTime tableReserveStartTime);
*/

    /*SELECT * FROM TABLE_RESTAURANT  WHERE TABLE_SIZE >=2
    and TABLE_RESERVE_START_DATE <='2022-07-12' and TABLE_RESERVE_END_TIME >='10:20' order by TABLE_SIZE ;
    */
   /* @Query(value = "SELECT tr FROM TableRestaurant  tr " +
            "WHERE tableSize >= :tableSize AND tableReserveStartDate <= :tableReserveStartDate AND tableReserveEndTime >= :tableReserveStartTime " +
            "ORDER BY tableSize ")
    public List<TableRestaurant> getFreeTable(@Param("tableSize") Long resertableSize,
                                              @Param("tableReserveStartDate") LocalDate tableReserveStartDate,
                                              @Param("tableReserveStartTime") LocalTime tableReserveStartTime);
*/
    Iterable<TableRestaurant> findByTableSizeGreaterThanEqual(Long l);
}