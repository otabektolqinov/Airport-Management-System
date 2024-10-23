package com.airport.Airport.Management.System.repository;

import com.airport.Airport.Management.System.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

    @Query(
            value = "select * from staff",
            nativeQuery = true
    )
    List<Staff> getAll();


}
