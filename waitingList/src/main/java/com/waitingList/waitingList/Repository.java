package com.waitingList.waitingList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Repository extends JpaRepository<Card, Long> {

    @Query(value = "SELECT * FROM Cards ORDER BY priority ASC, arrival_time ASC", nativeQuery = true)
    List<Card> findAll();
}
