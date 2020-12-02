package com.demos.begindemo.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demos.begindemo.pojo.bo.StudentBO;
import com.demos.begindemo.pojo.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    /**
     * 查询表student所有信息
     */
    List<Student> findAllStudent();

        /**
         * 分页查询
         * @param page
         * @return
         */
    List<Student> selectForPage(Page page, @Param("studentBO") StudentBO studentBO);



    /**
     * 根据主键id查询表student信息
     *
     * @param id
     */
    Student findStudentByid(@Param("id") Integer id);

    /**
     * 根据条件查询表student信息
     *
     * @param student
     */
    List<Student> findStudentByCondition(Student student);

    /**
     * 根据主键id查询表student信息
     *
     * @param id
     */
    Integer deleteStudentByid(@Param("id") Integer id);

    /**
     * 根据主键id更新表student信息
     *
     * @param student
     */
    Integer updateStudentByid(Student student);

    /**
     * 新增表student信息
     *
     * @param student
     */
    Integer addStudent(Student student);

}