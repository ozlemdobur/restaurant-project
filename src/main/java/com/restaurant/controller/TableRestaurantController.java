package com.restaurant.controller;

import com.restaurant.exceptions.NotAcceptableValueException;
import com.restaurant.model.TableRestaurant;
import com.restaurant.service.TableRestaurantService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("//api")
public class TableRestaurantController {
    protected static final Logger logger = LogManager.getLogger();

//    private TableRestaurantRepository tableRestaurantRepository;
    private TableRestaurantService tableRestaurantService;

    public TableRestaurantController() {
    }

//    @Autowired
//    public TableRestaurantController(TableRestaurantRepository tableRestaurantRepository) {
//        this.tableRestaurantRepository = tableRestaurantRepository;
//    }

    @Autowired
    public TableRestaurantController(TableRestaurantService tableRestaurantService) {
        this.tableRestaurantService = tableRestaurantService;
    }

    @GetMapping(value = "/tableRestaurant", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<TableRestaurant>> getAllRestaurantTables() {
        logger.info("Inside 'getAllRestaurantTables'");
        Iterable<TableRestaurant> restaurantTables = tableRestaurantService.findAll();
        return ResponseEntity.ok(restaurantTables);
    }

    @PostMapping(value = "/tableRestaurant", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TableRestaurant> saveRestaurantTable(@RequestBody TableRestaurant tableRestaurant) {
        logger.info("Inside 'saveRestaurantTable'");
        TableRestaurant isExist = tableRestaurantService.findByTableNumber(tableRestaurant.getTableNumber());
        if(isExist==null) {
            tableRestaurantService.save(tableRestaurant);
            return ResponseEntity.ok(tableRestaurant);
        }else{
            throw new NotAcceptableValueException("This table number exist.Please change the table number!");
        }

    }

    @DeleteMapping(value = "/tableRestaurant/{id}", produces= MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> deleteTableById( @PathVariable Long id){
        System.out.println("Inside deleteTableById");
        tableRestaurantService.deleteById(id);
        return ResponseEntity.ok( "Table with id: " + id + " is deleted");
    }

/*    // http://localhost:9090/api/reservation
    @GetMapping(value = "/tableRestaurant/tableControl/{tableNumber}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<TableRestaurant>> isTableNumberExist(@PathVariable Long tableNumber){
        Optional<TableRestaurant> tableRestaurant = tableRestaurantService.findByTableNumber(tableNumber);
        if(tableRestaurant.isEmpty()){
            throw new NotAcceptableValueException("This menu name exist.Please change the menu name!");
        }
        return ResponseEntity.ok(tableRestaurant);
    }*/

/*    @PostMapping(value = "/tableRestaurant/{howManyPeople}/{date}/{time}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<TableRestaurant>> getFreeTable(
            @PathVariable Long howManyPeople, @PathVariable String date, @PathVariable String time){
        System.out.println("Inside getAllReservations");
        System.out.println("date" + date.toString());
        System.out.println("time" + time.toString());
        Optional<TableRestaurant> tableRestaurant= tableRestaurantService.getCheckReservation(howManyPeople, date, time);

        return ResponseEntity.ok(tableRestaurant);
    }*/

}