package com.demos.musicmanager.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: jz
 * @Date: 2020/12/4 10:02
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MusicVO {
    private String name;
    private String artist;
    private String url;
    private String lrc;
    private String cover;

/*    public MusicVO() {
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
    }*/
}
