package com.demos.musicmanager.config.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: jz
 * @Date: 2020/12/2 17:38
 * @Description: 自定义异常
 */
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class BizException extends  RuntimeException {
    /**
     * 错误码
     */
    protected  Integer errorCode;

    /**
     * 错误信息
     */
    protected  String errMsg;
}
