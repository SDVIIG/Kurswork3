package com.example.demo.event.events;

import com.example.demo.dto.ChatDto;
import org.springframework.context.ApplicationEvent;

public class SynchronizationSendMessageEvent extends ApplicationEvent {

    public SynchronizationSendMessageEvent(ChatDto chatDto) {
        super(chatDto);
    }
}
