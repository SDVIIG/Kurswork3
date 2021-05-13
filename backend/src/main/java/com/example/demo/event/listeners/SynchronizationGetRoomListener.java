package com.example.demo.event.listeners;

import com.example.demo.dto.RoomLoginDto;
import com.example.demo.event.events.SynchronizationGetRoomEvent;
import com.example.demo.service.SynchronizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SynchronizationGetRoomListener {

    private final SynchronizationService synchronizationService;

    @EventListener
    public void onSynchronizationGetRoom(SynchronizationGetRoomEvent event) {
        RoomLoginDto roomLoginDto = (RoomLoginDto) event.getSource();
        synchronizationService.synchronizationGetRoom(roomLoginDto);
    }
}
