package com.example.demo.event.listeners;

import com.example.demo.dto.RoomLoginDto;
import com.example.demo.event.events.SynchronizationLoginRoomEvent;
import com.example.demo.service.SynchronizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SynchronizationLoginRoomListener {

    private final SynchronizationService synchronizationService;

    @EventListener
    public void onSynchronizationLoginRoomListener(SynchronizationLoginRoomEvent event) {
        RoomLoginDto roomLoginDto = (RoomLoginDto) event.getSource();
        synchronizationService.synchronizationLoginRoom(roomLoginDto);
    }
}
