package com.airport.Airport.Management.System.repository;

import com.airport.Airport.Management.System.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    Optional<Flight> findFlightByIdAndDeletedAtIsNull(Long id);

    @Query(nativeQuery = true, value = "select * from flight")
    List<Flight> findAll();


}

