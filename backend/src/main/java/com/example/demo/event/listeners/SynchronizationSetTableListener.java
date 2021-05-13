package com.example.demo.event.listeners;

import com.example.demo.dto.RoomTableMoveDto;
import com.example.demo.event.events.SynchronizationSetTableEvent;
import com.example.demo.service.SynchronizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SynchronizationSetTableListener {

    private final SynchronizationService synchronizationService;

    @EventListener
    public void onSynchronizationSetTable(SynchronizationSetTableEvent event) {
        RoomTableMoveDto table = (RoomTableMoveDto) event.getSource();
        synchronizationService.synchronizationSetTable(table);
    }
}
