package com.example.demo.event.listeners;

import com.example.demo.dto.RoomCreateDto;
import com.example.demo.dto.RoomCreateSyncDto;
import com.example.demo.event.events.SynchronizationCreateRoomEvent;
import com.example.demo.service.SynchronizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SynchronizationCreateRoomListener {

    private final SynchronizationService synchronizationService;

    @EventListener
    public void onSynchronizationCreateRoom(SynchronizationCreateRoomEvent event) {
        RoomCreateSyncDto createDto = (RoomCreateSyncDto) event.getSource();
        synchronizationService.synchronizationCreateRoom(createDto);
    }
}
