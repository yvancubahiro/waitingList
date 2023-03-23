package com.waitingList.waitingList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Card, Long> {
}
