package com.zms.learn.modle;

import com.zms.learn.enums.SuccessCodeEnum;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * The type Response.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Response implements Serializable {
    private static final long serialVersionUID = 10L;

    @Builder.Default
    private Integer returnCode = SuccessCodeEnum.SUCCESS.getValue();

    @Builder.Default
    private String returnMsg = "success";

    @Builder.Default
    private String returnUserMsg = SuccessCodeEnum.SUCCESS.getDesc();

    private Object data;

    private List list;

    public static Response succ() {
        return new Response();
    }

    public static Response succ(Object data) {
        Response response = new Response();
        response.setData(data);
        return response;
    }

    /**
     * Sets error.
     *
     * @param code    the code
     * @param message the message
     */
    public void setError(Integer code, String message) {
        this.setReturnCode(code);
        this.setReturnMsg(message);
        this.setReturnUserMsg(message);
    }

    /**
     * Sets full error.
     *
     * @param code    the code
     * @param msg     the msg
     * @param userMsg the user msg
     */
    public void setFullError(Integer code, String msg, String userMsg) {
        this.setReturnCode(code);
        this.setReturnMsg(msg);
        this.setReturnUserMsg(userMsg);
    }
}