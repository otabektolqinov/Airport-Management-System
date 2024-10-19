package com.airport.Airport.Management.System.repository;

import com.airport.Airport.Management.System.model.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GateRepository extends JpaRepository<Gate, Long> {

    @Query(
            value = "select * from gate",
            nativeQuery = true
    )
    List<Gate> getAllGates();
}
