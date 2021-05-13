package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoomCreateSyncDto {
    private Long roomId;
    private String userId;
    private String nickname;
}
