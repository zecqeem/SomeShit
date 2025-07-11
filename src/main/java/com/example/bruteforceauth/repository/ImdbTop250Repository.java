package com.example.bruteforceauth.repository;

import com.example.bruteforceauth.model.ImdbTop250;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImdbTop250Repository extends JpaRepository<ImdbTop250, Long> {
    boolean existsByTitleAndYear(String title, String year);
}