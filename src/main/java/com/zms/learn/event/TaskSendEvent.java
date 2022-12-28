package com.zms.learn.event;

import com.zms.learn.modle.dto.EventDTO;

public class TaskSendEvent extends BaseEvent{
    public TaskSendEvent(Object source, EventDTO eventDTO) {
        super(source, eventDTO);
    }
}
