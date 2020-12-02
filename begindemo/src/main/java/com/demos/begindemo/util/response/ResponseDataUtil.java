package com.demos.begindemo.util.response;

import com.demos.begindemo.util.enums.ResultEnums;

/**
 * @author: jz
 * @Date: 2020/11/27 10:10
 * @Description: 统一返回工具类
 */
public class ResponseDataUtil {
    public static <T> ResponseData buildSuccess(T data) {
        return new ResponseData<T>(ResultEnums.SUCCESS, data);
    }

    public static ResponseData buildSuccess() {
        return new ResponseData(ResultEnums.SUCCESS);
    }

    public static ResponseData buildSuccess(String msg) {
        return new ResponseData(ResultEnums.SUCCESS.getCode(), msg);
    }

    public static ResponseData buildSuccess(int code, String msg) {
        return new ResponseData(code, msg);
    }

    public static <T> ResponseData buildSuccess(int code, String msg, T data) {
        return new ResponseData<T>(code, msg, data);
    }

    public static ResponseData buildSuccess(ResultEnums resultEnums) {
        return new ResponseData(resultEnums);
    }

    public static <T> ResponseData buildError(T data) {
        return new ResponseData<T>(ResultEnums.ERROR, data);
    }

    public static ResponseData buildError() {
        return new ResponseData(ResultEnums.ERROR);
    }

    public static ResponseData buildError(String msg) {
        return new ResponseData(ResultEnums.ERROR.getCode(), msg);
    }

    public static ResponseData buildError(int code, String msg) {
        return new ResponseData(code, msg);
    }

    public static <T> ResponseData buildError(int code, String msg, T data) {
        return new ResponseData<T>(code, msg, data);
    }

    public static ResponseData buildError(ResultEnums resultEnums) {
        return new ResponseData(resultEnums);
    }
}
