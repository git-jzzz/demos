package com.demos.begindemo.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demos.begindemo.mapper.ClassesMapper;
import com.demos.begindemo.mapper.GradeMapper;
import com.demos.begindemo.mapper.StudentMapper;
import com.demos.begindemo.pojo.bo.StudentBO;
import com.demos.begindemo.pojo.entity.Classes;
import com.demos.begindemo.pojo.entity.Grade;
import com.demos.begindemo.pojo.entity.Student;
import com.demos.begindemo.pojo.vo.StudentVO;
import com.demos.begindemo.service.StudentService;
import com.demos.begindemo.util.enums.SexEnums;
import com.demos.begindemo.util.page.CommonPageResult;
import com.demos.begindemo.util.page.PageUtils;
import com.demos.begindemo.util.response.ResponseData;
import com.demos.begindemo.util.response.ResponseDataUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private GradeMapper gradeMapper;

    @Autowired
    private ClassesMapper classesMapper;

    /**
     * 查询表student所有信息
     */
    @Override
    public List<Student> findAllStudent() {
        return studentMapper.findAllStudent();
    }


    @Override
    public ResponseData<CommonPageResult<StudentVO>> selectForPage(StudentBO studentBO) {
        Page page= PageUtils.toPage(studentBO);
        List<Student> students = studentMapper.selectForPage(page,studentBO);
        List<Classes> classes = classesMapper.findAllClasses();
        List<Grade> grades = gradeMapper.findAllGrade();
        List<StudentVO> studentVOList = students.stream().map(student -> {
            StudentVO studentVO = new StudentVO();
            BeanUtils.copyProperties(student, studentVO);
            studentVO.setSexDesc(SexEnums.getDesc(studentVO.getSex()));
            classes.stream().filter(classes1 -> classes1.getId().equals(studentVO.getClassId())).findFirst().ifPresent(
                    classes1 -> {
                        studentVO.setClassName(classes1.getClassName());
                        grades.stream().filter(grade -> grade.getId().equals(classes1.getGradeId())).findFirst().ifPresent(
                                grade -> {
                                    studentVO.setGradeName(grade.getGradeName());
                                }
                        );
                    });
            return studentVO;
        }).collect(Collectors.toList());
        return ResponseDataUtil.buildSuccess(PageUtils.toPageResult(page,studentVOList));
    }

    /**
     * 根据主键id查询表student信息
     *
     * @param id
     */
    @Override
    public Student findStudentByid(@Param("id") Integer id) {
        return studentMapper.findStudentByid(id);
    }

    /**
     * 根据条件查询表student信息
     *
     * @param student
     */
    @Override
    public List<Student> findStudentByCondition(Student student) {
        return studentMapper.findStudentByCondition(student);
    }

    /**
     * 根据主键id查询表student信息
     *
     * @param id
     */
    @Override
    public Integer deleteStudentByid(@Param("id") Integer id) {
        return studentMapper.deleteStudentByid(id);
    }

    /**
     * 根据主键id更新表student信息
     *
     * @param student
     */
    @Override
    public Integer updateStudentByid(Student student) {
        return studentMapper.updateStudentByid(student);
    }

    /**
     * 新增表student信息
     *
     * @param student
     */
    @Override
    public Integer addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

}