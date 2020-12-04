package com.demos.musicmanager.util.response;

import com.demos.musicmanager.util.enums.ResultEnums;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: jz
 * @Date: 2020/11/27 10:01
 * @Description:  统一返回
 */
@Data
public class ResponseData<T> implements Serializable {
    private int code;

    private  String msg;

    private T data;

    public ResponseData(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseData(ResultEnums resultEnums) {
        this.code = resultEnums.getCode();
        this.msg = resultEnums.getDesc();
    }

    public ResponseData(ResultEnums resultEnums, T data) {
        this.code = resultEnums.getCode();
        this.msg = resultEnums.getDesc();
        this.data = data;
    }

    public ResponseData() {
    }
}
