package com.zms.learn.modle.bo.message;

import com.zms.learn.constant.enums.MessageEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseMessage {
    String requestId;

    String station;

    MessageEnum type;

}
