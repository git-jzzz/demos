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
     * 1网易云id 2 咪咕链接
     */
    private int status;

    /**
     * url链接
     */
    private String url;



    /**
     * 网易云id
     */
    private String wyyId;

    /**
     * 封面图片url
     */
    private String coverUrl;

    /**
     * 歌曲名
     */
    private String songName;

    /**
     * 作者名
     */
    private String songAuthor;


}
