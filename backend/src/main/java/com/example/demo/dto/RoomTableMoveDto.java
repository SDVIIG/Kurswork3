package com.example.demo.dto;

import lombok.Data;

@Data
public class RoomTableMoveDto {
    long roomId;
    String userId;
    int index;
}
