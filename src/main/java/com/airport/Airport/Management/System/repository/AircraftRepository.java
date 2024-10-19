package com.airport.Airport.Management.System.repository;

import com.airport.Airport.Management.System.model.Aircraft;
import com.airport.Airport.Management.System.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Long> {

    @Query(
            value = "select * from aircraft",
            nativeQuery = true
    )
    List<Aircraft> getAll();
}
