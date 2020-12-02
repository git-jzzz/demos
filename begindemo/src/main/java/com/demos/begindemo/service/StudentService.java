package com.demos.begindemo.service;

import com.demos.begindemo.pojo.bo.StudentBO;
import com.demos.begindemo.pojo.entity.Student;
import com.demos.begindemo.pojo.vo.StudentVO;
import com.demos.begindemo.util.page.CommonPageResult;
import com.demos.begindemo.util.response.ResponseData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {

    /**
     * 查询表student所有信息
     */
    List<Student> findAllStudent();

    /**
     * 分页查询
     * @return
     */
    ResponseData<CommonPageResult<StudentVO>> selectForPage(StudentBO studentVOs);

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