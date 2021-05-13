package com.example.demo.repository;

import com.example.demo.model.Room;
import com.example.demo.model.RoomTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTableRepository extends JpaRepository<RoomTable, Integer> {
    RoomTable findByIndexAndRoom(int index, Room room);
}
