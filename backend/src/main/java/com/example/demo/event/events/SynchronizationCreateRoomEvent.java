package com.example.demo.event.events;

import com.example.demo.dto.RoomCreateSyncDto;
import org.springframework.context.ApplicationEvent;

public class SynchronizationCreateRoomEvent extends ApplicationEvent {
    public SynchronizationCreateRoomEvent(RoomCreateSyncDto createDto) {
        super(createDto);
    }
}
