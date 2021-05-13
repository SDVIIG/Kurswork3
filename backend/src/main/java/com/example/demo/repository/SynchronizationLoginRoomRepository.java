package com.example.demo.repository;

import com.example.demo.model.SynchronizationLoginRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SynchronizationLoginRoomRepository extends JpaRepository<SynchronizationLoginRoom, Integer> {
    List<SynchronizationLoginRoom> findAllByServerPort(int serverPort);
}
