package com.example.demo.repository;

import com.example.demo.model.SynchronizationCreateRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SynchronizationCreateRoomRepository extends JpaRepository<SynchronizationCreateRoom, Integer> {
    List<SynchronizationCreateRoom> findAllByServerPort(int serverPort);
}
