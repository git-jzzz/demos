package com.demos.musicmanager.util.enums;

/**
 * @author: jz
 * @Date: 2020/11/27 10:04
 * @Description: 状态枚举
 */
public enum ResultEnums {
    SUCCESS(0000, "请求成功"),
    ERROR(1111, "请求失败"),
    SYSTEM_ERROR(1000, "系统异常"),
    NULL_ERROR(1001,"空指针异常"),
    BUSSINESS_ERROR(2001, "业务逻辑错误"),
    VERIFY_CODE_ERROR(2002, "参数验证错误"),
    PARAM_ERROR(2003, "业务参数错误");



    private int code;
    private String desc;


    ResultEnums(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getDesc(int code) {
        ResultEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ResultEnums item = var1[var3];
            if(item.code == code) {
                return item.desc;
            }
        }

        return code + "";
    }



    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
