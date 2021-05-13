package com.example.demo.dto;

import com.example.demo.model.Marker;
import com.example.demo.model.RoomPlayer;
import lombok.Data;

@Data
public class RoomPlayerDto {
    private String id;
    private Marker marker;
    private boolean win;
    private boolean move;
    private String nickname;

    public RoomPlayerDto(RoomPlayer roomPlayer) {
        this.id = roomPlayer.getId();
        this.marker = roomPlayer.getMarker();
        this.win = roomPlayer.isWin();
        this.move = roomPlayer.isMove();
        this.nickname = roomPlayer.getNickname();
    }
}
