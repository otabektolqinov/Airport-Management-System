package com.airport.Airport.Management.System.repository;

import com.airport.Airport.Management.System.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {

    @Query(
            value = "select * from airline",
            nativeQuery = true
    )
    List<Airline> getAll();

}
