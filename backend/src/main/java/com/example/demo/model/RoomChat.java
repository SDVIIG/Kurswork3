package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.Clock;
import java.util.Date;

@Entity
@Table(name = "RoomChat")
@Data
public class RoomChat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userId;

    private String nickname;

    @Size(max = 500, message = "А поменьше 500 символов нельзя?")
    private String message;

    @ManyToOne
    @JoinColumn(name = "Room_id", nullable = false)
    private Room room;

    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate = new Date(Clock.systemUTC().millis());
}
