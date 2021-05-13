package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Clock;
import java.util.Date;

@Data
@Entity
@Table(name = "SynchronizationCreateRoom")
@NoArgsConstructor
public class SynchronizationCreateRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userId;

    private String nickname;

    private int serverPort;

    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate = new Date(Clock.systemUTC().millis());

    public SynchronizationCreateRoom(String userId, int serverPort, String nickname) {
        this.userId = userId;
        this.serverPort = serverPort;
        this.nickname = nickname;
    }
}
