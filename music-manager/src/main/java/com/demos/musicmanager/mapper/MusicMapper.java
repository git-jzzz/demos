package com.demos.musicmanager.mapper;

import com.demos.musicmanager.pojo.entity.Music;

import java.util.List;

import com.demos.musicmanager.pojo.vo.MusicVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface MusicMapper {

    /**
     * 查询表music所有信息
     */
    List<Music> findAllMusic();

    /**
     * 根据主键id查询表music信息
     *
     * @param id
     */
    Music findMusicByid(@Param("id") Integer id);

    /**
     * 根据条件查询表music信息
     *
     * @param music
     */
    List<Music> findMusicByCondition(Music music);

    /**
     * 根据主键id查询表music信息
     *
     * @param id
     */
    Integer deleteMusicByid(@Param("id") Integer id);

    /**
     * 根据主键id更新表music信息
     *
     * @param music
     */
    Integer updateMusicByid(Music music);

    /**
     * 新增表music信息
     *
     * @param music
     */
    Integer addMusic(Music music);

    List<MusicVO> imports();

}