package com.restaurant.controller;

import com.restaurant.model.TableRestaurant;
import com.restaurant.service.TableRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;


@RestController
@RequestMapping("//api")
public class TableRestaurantController {
    protected static final Logger logger = LogManager.getLogger();

    private TableRestaurantService tableRestaurantService;

    public TableRestaurantController() {
    }

    @Autowired
    public TableRestaurantController(TableRestaurantService tableRestaurantService) {
        this.tableRestaurantService = tableRestaurantService;
    }

    @GetMapping(value = "/tableRestaurant", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<TableRestaurant>> getAllRestaurantTables() {
        logger.info("Inside 'getAllRestaurantTables'");
        Iterable<TableRestaurant> restaurantTables = tableRestaurantService.findAll();
        System.out.println(tableRestaurantService.findByEmptyTables());
        return ResponseEntity.ok(restaurantTables);
    }

    @PostMapping(value = "/tableRestaurant", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TableRestaurant> saveRestaurantTable(@RequestBody TableRestaurant tableRestaurant) {
        logger.info("Inside 'saveRestaurantTable'");
        tableRestaurantService.save(tableRestaurant);
        return ResponseEntity.ok(tableRestaurant);
    }

    @DeleteMapping(value = "/tableRestaurant/{id}", produces= MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> deleteTableById( @PathVariable Long id){
        System.out.println("Inside deleteTableById");
        tableRestaurantService.deleteById(id);
        return ResponseEntity.ok( "Table with id: " + id + " is deleted");
    }

    @PostMapping(value = "/tableRestaurant/{howManyPeople}/{date}/{time}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<TableRestaurant>> getFreeTable(
            @PathVariable Long howManyPeople, @PathVariable String date, @PathVariable String time){
        System.out.println("Inside getAllReservations");
        System.out.println("date" + date.toString());
        System.out.println("time" + time.toString());
        Optional<TableRestaurant> tableRestaurant= tableRestaurantService.getFreeTable(howManyPeople, date, time);
        return ResponseEntity.ok(tableRestaurant);
    }
}