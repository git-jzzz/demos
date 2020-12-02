package com.demos.begindemo.util.enums;

/**
 * @author: jz
 * @Date: 2020/11/27 15:50
 * @Description: 性别状态枚举
 */
public enum SexEnums {
    MAN(1,"男性"),WOMAN(0,"女性");



    private int code;
    private String desc;


    SexEnums(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getDesc(int code) {
        SexEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            SexEnums item = var1[var3];
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
