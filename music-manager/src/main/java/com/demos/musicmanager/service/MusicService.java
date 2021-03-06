package com.demos.musicmanager.service;

import com.demos.musicmanager.pojo.bo.MusicBO;
import com.demos.musicmanager.pojo.entity.Music;
import com.demos.musicmanager.util.response.ResponseData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MusicService {
    /**
     * 添加音乐
     * @param musicBO
     * @return
     * @throws Exception
     */
    ResponseData addMusic(MusicBO musicBO) throws Exception;

    /**
     * 导入原数据库音乐
     * @return
     * @throws Exception
     */
    ResponseData imports() throws  Exception;
}