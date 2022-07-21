package com.restaurant.service;

import com.restaurant.exception.NoSuitableTableException;
import com.restaurant.model.Reservation;
import com.restaurant.model.TableRestaurant;
import com.restaurant.repository.ReservationRepository;
import com.restaurant.repository.TableRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    TableRestaurantRepository tableRestaurantRepository;

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private TableRestaurantServiceImpl imp;


    public ReservationServiceImpl() {
    }

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Iterable<Reservation> findAll() {
        Iterable<Reservation> reservations = reservationRepository.findAll();
        return reservations;
    }

    @Override
    public Optional<Reservation> findByFirstName(String firstName) {
        return reservationRepository.findByFirstName(firstName);
    }

    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);

    }

    @Override
    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation checkAndMakeReservation(Reservation requestReservation) {
        System.out.println("inside makeControlFreeTable");
        System.out.println(requestReservation.getHowManyPeople());
        List<TableRestaurant> tbs = getTableGreaterEqualThanPerson(requestReservation.getHowManyPeople());

        List<Reservation> allReservedTablesSameTime = getAllReservedTablesSameTime(requestReservation);
        Reservation setReservation;
        List <Long> usedTables =new ArrayList<>();
        for(Reservation usedTable :allReservedTablesSameTime ){
            usedTables.add(usedTable.getTableId());
        }
        for (TableRestaurant tableIsFree : tbs) {
           if(!usedTables.contains(tableIsFree.getTableNumber())){

               setReservation = new Reservation(requestReservation.getId(),
                               requestReservation.getFirstName(),
                               requestReservation.getLastName(),
                               requestReservation.getEmail(),
                               requestReservation.getPhone(),
                               requestReservation.getDate(),
                               requestReservation.getTime(),
                               requestReservation.getTime().plusHours(2),
                               requestReservation.getHowManyPeople(),
                               requestReservation.isBabyChair(),
                               tableIsFree.getTableNumber()
               );
               reservationRepository.save(setReservation);
               //System.out.println(setReservation.toString());
               return setReservation;
           }
        }

        return null;
    }


    public List<Reservation> getAllReservedTablesSameTime(Reservation reqRes) {
        Iterable<Reservation> getReservations = reservationRepository.getReservedTableSameTime(reqRes.getHowManyPeople(), reqRes.getDate());
        return (List<Reservation>) getReservations;

    }

    public List<TableRestaurant> getTableGreaterEqualThanPerson(Long howManyPeople) {
        Iterable<TableRestaurant> allTables = tableRestaurantRepository.findByTableSizeGreaterThanEqual(howManyPeople);
        for (TableRestaurant ts : allTables) {
            System.out.println(ts.getId() + " getId" + ts.getTableSize() + " getTableSize" + ts.getTableNumber());
        }
        return (List<TableRestaurant>) allTables;

    }



/*    public int splitHourMinute(String hourOrMinute, String startTime) {
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
    }*/

}