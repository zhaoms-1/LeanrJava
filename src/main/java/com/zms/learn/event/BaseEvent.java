package com.zms.learn.event;

import com.zms.learn.modle.dto.EventDTO;
import org.springframework.context.ApplicationEvent;

public abstract class BaseEvent extends ApplicationEvent {

    private EventDTO eventDTO;

    public BaseEvent(Object source, EventDTO eventDTO) {
        super(source);
        this.eventDTO = eventDTO;
    }

    public EventDTO getEventDTO() {
        return this.eventDTO;
    }
}
