package com.example.demo.repository;

import com.example.demo.model.SynchronizationSendMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SynchronizationSendMessageRepository extends JpaRepository<SynchronizationSendMessage, Integer> {
    List<SynchronizationSendMessage> findAllByServerPort(int serverPort);
}
