package com.example.demo.event.events;

import com.example.demo.dto.RoomTableMoveDto;
import org.springframework.context.ApplicationEvent;

public class SynchronizationSetTableEvent extends ApplicationEvent {

    public SynchronizationSetTableEvent(RoomTableMoveDto table) {
        super(table);
    }
}
