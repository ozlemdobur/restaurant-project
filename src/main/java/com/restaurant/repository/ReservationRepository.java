package com.restaurant.repository;

import com.restaurant.model.Reservation;
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
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    Optional<Reservation> findByFirstName(String firstName);

    //List<Reservation> findByDateAndTimeEqualThan(LocalDate localDate, LocalTime localTime);

    @Query(value = "Select rs from Reservation rs  where howManyPeople >=:howManyPeople  and date=:date " +
                    " order by tableId")
    public List<Reservation> getReservedTableSameTime(@Param("howManyPeople") Long howManyPeople,
                                              @Param("date") LocalDate date
                                              );

}
