package com.demos.begindemo.mapper;

import com.demos.begindemo.pojo.entity.Grade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GradeMapper {

    /**
     * 查询表grade所有信息
     */
    List<Grade> findAllGrade();

    /**
     * 根据主键id查询表grade信息
     *
     * @param id
     */
    Grade findGradeByid(@Param("id") Integer id);

    /**
     * 根据条件查询表grade信息
     *
     * @param grade
     */
    List<Grade> findGradeByCondition(Grade grade);

    /**
     * 根据主键id查询表grade信息
     *
     * @param id
     */
    Integer deleteGradeByid(@Param("id") Integer id);

    /**
     * 根据主键id更新表grade信息
     *
     * @param grade
     */
    Integer updateGradeByid(Grade grade);

    /**
     * 新增表grade信息
     *
     * @param grade
     */
    Integer addGrade(Grade grade);

}