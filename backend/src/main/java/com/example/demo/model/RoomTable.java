package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "RoomTable")
public class RoomTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int index;

    private Marker marker;

    @ManyToOne
    @JoinColumn(name = "Room_id", nullable = false)
    private Room room;
}
