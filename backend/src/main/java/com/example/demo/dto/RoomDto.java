package com.example.demo.dto;

import com.example.demo.model.Marker;
import com.example.demo.model.RoomStatus;
import lombok.Data;

import java.util.List;

@Data
public class RoomDto {
    private int id;
    private RoomStatus status;
    private List<RoomPlayerDto> players;
    private List<Marker> table;
}
