package com.demos.begindemo.mapper;

import com.demos.begindemo.pojo.entity.Classes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassesMapper {

    /**
     * 查询表classes所有信息
     */
    List<Classes> findAllClasses();

    /**
     * 根据主键id查询表classes信息
     *
     * @param id
     */
    Classes findClassesByid(@Param("id") Integer id);

    /**
     * 根据条件查询表classes信息
     *
     * @param classes
     */
    List<Classes> findClassesByCondition(Classes classes);

    /**
     * 根据主键id查询表classes信息
     *
     * @param id
     */
    Integer deleteClassesByid(@Param("id") Integer id);

    /**
     * 根据主键id更新表classes信息
     *
     * @param classes
     */
    Integer updateClassesByid(Classes classes);

    /**
     * 新增表classes信息
     *
     * @param classes
     */
    Integer addClasses(Classes classes);

}