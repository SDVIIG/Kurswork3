package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Clock;
import java.util.Date;

@Data
@Entity
@Table(name = "SynchronizationSetTable")
@NoArgsConstructor
public class SynchronizationSetTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int serverPort;

    private String userId;

    private long roomId;

    private int index;

    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate = new Date(Clock.systemUTC().millis());

    public SynchronizationSetTable(int serverPort, String userId, long roomId, int index) {
        this.serverPort = serverPort;
        this.userId = userId;
        this.roomId = roomId;
        this.index = index;
    }
}
