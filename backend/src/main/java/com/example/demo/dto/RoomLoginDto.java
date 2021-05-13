package com.example.demo.dto;

import lombok.Data;

@Data
public class RoomLoginDto {
    private String userId;
    private long roomId;
    private String nickname;
}
