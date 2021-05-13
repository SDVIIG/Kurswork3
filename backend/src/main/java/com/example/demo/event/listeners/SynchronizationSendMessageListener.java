package com.example.demo.event.listeners;

import com.example.demo.dto.ChatDto;
import com.example.demo.event.events.SynchronizationSendMessageEvent;
import com.example.demo.service.SynchronizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SynchronizationSendMessageListener {

    private final SynchronizationService synchronizationService;

    @EventListener
    public void onSynchronizationSendMessage(SynchronizationSendMessageEvent event) {
        ChatDto chatDto = (ChatDto) event.getSource();
        synchronizationService.synchronizationSendMessage(chatDto);
    }

}
