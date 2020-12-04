package com.demos.musicmanager.pojo.bo;

import lombok.Data;

/**
 * @author: jz
 * @Date: 2020/12/3 10:25
 * @Description: 参数
 */
@Data
public class MusicBO {
    /**
     * 1直接输入链接 2 咪咕链接
     */
    private int status;

    /**
     * url链接
     */
    private String url;
}
