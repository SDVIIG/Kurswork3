package com.example.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "RoomPlayer")
@EqualsAndHashCode(of = {"id"})
public class RoomPlayer {
    @Id
    private String id;

    private Marker marker;

    private boolean win;

    private boolean move;

    private String nickname;
}
