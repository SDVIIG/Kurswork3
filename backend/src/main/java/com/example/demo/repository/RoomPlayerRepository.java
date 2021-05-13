package com.example.demo.repository;

import com.example.demo.model.RoomPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomPlayerRepository extends JpaRepository<RoomPlayer, String> {

    Optional<RoomPlayer> findById(String userId);

}
