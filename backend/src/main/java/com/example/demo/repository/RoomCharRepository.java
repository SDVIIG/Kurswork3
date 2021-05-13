package com.example.demo.repository;

import com.example.demo.model.RoomChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomCharRepository extends JpaRepository<RoomChat, Integer> {
}
