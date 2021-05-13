package com.example.demo.event.events;

import com.example.demo.dto.RoomLoginDto;
import org.springframework.context.ApplicationEvent;

public class SynchronizationLoginRoomEvent extends ApplicationEvent {
    public SynchronizationLoginRoomEvent(RoomLoginDto roomLoginDto) {
        super(roomLoginDto);
    }
}
