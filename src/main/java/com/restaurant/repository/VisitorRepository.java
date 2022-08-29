package com.restaurant.repository;

import com.restaurant.model.Visitor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitorRepository extends CrudRepository<Visitor, Long> {

    @Query(value = "SELECT count(status) FROM Visitor where status = :status")
    public Long count(@Param("status") String status);

    //?? why does not it work? :)
    //Long countByStatus(String status);


}
