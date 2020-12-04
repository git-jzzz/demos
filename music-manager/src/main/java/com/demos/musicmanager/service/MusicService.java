package com.demos.musicmanager.service;

import com.demos.musicmanager.pojo.bo.MusicBO;
import com.demos.musicmanager.pojo.entity.Music;
import com.demos.musicmanager.util.response.ResponseData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MusicService {
         ResponseData addMusic(MusicBO musicBO) throws  Exception;
}