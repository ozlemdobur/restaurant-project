package com.restaurant.service;

import com.restaurant.model.TableRestaurant;
import com.restaurant.repository.TableRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TableRestaurantServiceImpl implements TableRestaurantService {
    TableRestaurantRepository tableRestaurantRepository;

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

    @Override
    public Optional<TableRestaurant> getFreeTable(Long howManyPeople, String date, String time) {
        System.out.println("inside makeControlFreeTable");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);

        int reservationHour = splitHourMinute("H", time);
        int reservationMinute = splitHourMinute("M", time);
        LocalTime localTime = LocalTime.of(reservationHour, reservationMinute);

       // LocalTime localTime = LocalTime.parse(time);
        List<TableRestaurant> tables = tableRestaurantRepository.getFreeTable(howManyPeople, localDate, localTime);
        if(!tables.isEmpty()){
            Optional<TableRestaurant> freeTable= tableRestaurantRepository.findById(tables.get(0).getId());
            System.out.println(freeTable.get().getId());
            TableRestaurant tableRestaurant=new TableRestaurant(null,freeTable.get().getTableNumber(),
                    freeTable.get().getTableSize(),localDate,localTime,localTime.plusHours(2));
            tableRestaurantRepository.save(tableRestaurant);
            return tableRestaurantRepository.findById(tables.get(0).getId());
        }
        return  null;
    }

    public int splitHourMinute(String hourOrMinute, String startTime) {
        int part = 0;
        if (startTime.contains(":")) {
            String[] parts = startTime.split(":");
            if (hourOrMinute.equals("H")) {
                part = Integer.parseInt(parts[0]);
            } else {
                part = Integer.parseInt(parts[1]);
            }
        }
        return part;
    }

}