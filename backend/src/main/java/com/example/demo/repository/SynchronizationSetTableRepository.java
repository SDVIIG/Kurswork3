package com.example.demo.repository;

import com.example.demo.model.SynchronizationSetTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SynchronizationSetTableRepository extends JpaRepository<SynchronizationSetTable, Integer> {
    List<SynchronizationSetTable> findAllByServerPort(int serverPort);
}
