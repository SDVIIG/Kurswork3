package com.example.demo.service;

import com.example.demo.model.Marker;
import com.example.demo.model.RoomPlayer;
import com.example.demo.repository.RoomPlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomPlayerService {

    private final RoomPlayerRepository roomPlayerRepository;

    public RoomPlayer createPlayer(String userId, String nickname, Marker marker, boolean move) {

        RoomPlayer roomPlayer = roomPlayerRepository.findById(userId).orElse(null);
        if (roomPlayer == null) {
            RoomPlayer player = new RoomPlayer();
            player.setId(userId);
            player.setMarker(marker);
            player.setMove(move);
            player.setWin(false);
            player.setNickname(nickname);
            return roomPlayerRepository.save(player);
        } else {
            roomPlayer.setMarker(marker);
            roomPlayer.setMove(move);
            roomPlayer.setNickname(nickname);
            return roomPlayerRepository.save(roomPlayer);
        }
    }

    public RoomPlayer getPlayer(String userId) {
        return roomPlayerRepository.findById(userId).orElse(null);
    }

}
