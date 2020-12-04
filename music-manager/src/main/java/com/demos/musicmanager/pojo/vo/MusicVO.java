package com.demos.musicmanager.pojo.vo;

import com.demos.musicmanager.pojo.entity.Music;
import lombok.Data;

/**
 * @author: jz
 * @Date: 2020/12/4 10:02
 * @Description:
 */
@Data
public class MusicVO {
    private String name;
    private String artist;
    private String url;
    private String lrc;
    private String cover;

    public MusicVO() {
    }

    public MusicVO(String name,
                   String artist,
                   String url,
                   String lrc,
                   String cover) {
        this.name = name;
        this.artist = artist;
        this.lrc = lrc;
        this.url = url;
        this.cover = cover;
    }
}
