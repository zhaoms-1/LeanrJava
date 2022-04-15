package com.zms.learn.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class TestDto {
    private Long id;
    private String msg;
}
