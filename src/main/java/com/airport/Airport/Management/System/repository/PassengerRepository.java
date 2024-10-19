package com.airport.Airport.Management.System.repository;

import com.airport.Airport.Management.System.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    Optional<Passenger> findById(Long id);

    @Query(nativeQuery = true, value = "select * from passenger")
    List<Passenger> getAllPassenger();
}
