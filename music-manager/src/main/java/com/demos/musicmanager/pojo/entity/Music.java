package com.demos.musicmanager.pojo.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
* music : 
*/
@Data
public class Music  implements Serializable {

private static final long serialVersionUID = 1L;

        /**
        * 主键 : id,  数据库主键
        */
        private Integer id;

        /**
        * song_name,  歌曲名
        */
        private String songName;

        /**
        * song_author,  作者
        */
        private String songAuthor;

        /**
        * song_url,  歌曲路径
        */
        private String songUrl;

        /**
        * lrc_url,  歌词路径
        */
        private String lrcUrl;

        /**
        * cover_url,  歌曲封面路径
        */
        private String coverUrl;

        /**
        * status,  1:使用  2禁用
        */
        private Integer status;

public Music(Integer id,String songName,String songAuthor,String songUrl,String lrcUrl,String coverUrl,Integer status){
    this.id = id;
    this.songName = songName;
    this.songAuthor = songAuthor;
    this.songUrl = songUrl;
    this.lrcUrl = lrcUrl;
    this.coverUrl = coverUrl;
    this.status = status;
}

public Music(){
}


}