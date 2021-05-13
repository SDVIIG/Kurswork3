package com.example.demo.model;

import com.example.demo.exception.RoomException;
import lombok.Data;

import javax.persistence.*;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Room")
public class Room {
    @Id
    private long id;

    private RoomStatus roomStatus;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<RoomPlayer> players = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date getPlayer1 = new Date(Clock.systemUTC().millis());

    @Temporal(TemporalType.TIMESTAMP)
    private Date getPlayer2 = new Date(Clock.systemUTC().millis());

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "room")
    private List<RoomTable> table = new ArrayList<>() {
        @Override
        public boolean add(RoomTable v) {
            if (size() < 10) {
                return super.add(v);
            }
            throw new RoomException("выход за пределы поля");
        }
    };

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "room")
    private List<RoomChat> messages;
}
