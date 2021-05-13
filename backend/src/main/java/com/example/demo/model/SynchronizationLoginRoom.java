package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Clock;
import java.util.Date;

@Entity
@Table(name = "SynchronizationLoginRoom")
@Data
@NoArgsConstructor
public class SynchronizationLoginRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int serverPort;

    private String userId;

    private String nickname;

    private long roomId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate = new Date(Clock.systemUTC().millis());

    public SynchronizationLoginRoom(int serverPort, String userId, long roomId, String nickname) {
        this.serverPort = serverPort;
        this.userId = userId;
        this.roomId = roomId;
        this.nickname = nickname;
    }
}
