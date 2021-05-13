package com.example.demo.event.events;

import com.example.demo.dto.RoomLoginDto;
import org.springframework.context.ApplicationEvent;

public class SynchronizationGetRoomEvent extends ApplicationEvent {
    public SynchronizationGetRoomEvent(RoomLoginDto roomLoginDto) {
        super(roomLoginDto);
    }
}
