package com.airport.Airport.Management.System.repository;

import com.airport.Airport.Management.System.model.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerminalRepository extends JpaRepository<Terminal, Long> {

    @Query(
            value = "select * from terminal",
            nativeQuery = true
    )
    List<Terminal> getAll();
}
