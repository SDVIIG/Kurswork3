package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Clock;
import java.util.Date;

@Entity
@Table(name = "SynchronizationSendMessage")
@Data
@NoArgsConstructor
public class SynchronizationSendMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int serverPort;

    private String userId;

    private long roomId;

    private String message;

    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate = new Date(Clock.systemUTC().millis());

    public SynchronizationSendMessage(int serverPort, String userId, long roomId, String message) {
        this.serverPort = serverPort;
        this.userId = userId;
        this.roomId = roomId;
        this.message = message;
    }
}
