package com.airport.Airport.Management.System.repository;

import com.airport.Airport.Management.System.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

    @Query(
            value = "select * from airport",
            nativeQuery = true
    )
    List<Airport> getAll();

}
