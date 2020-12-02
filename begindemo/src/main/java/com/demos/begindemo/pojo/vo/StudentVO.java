package com.demos.begindemo.pojo.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author: jz
 * @Date: 2020/11/27 13:34
 * @Description:
 */
@Data
public class StudentVO  {
    /**
     * 主键 : id,  主键
     */
    private Integer id;

    /**
     * name,  学生名
     */
    private String name;

    /**
     * sex,  学生性别
     */
    private Integer sex;

    private String sexDesc;

    /**
     * age,  年龄
     */
    private Integer age;

    /**
     * address,  家庭住址
     */
    private String address;

    /**
     * classId,  班级id
     */
    private Integer classId;

    /**
     *班级名
     */
    private String className;


    private  String gradeName;

    /**
     * number,  学号
     */
    private String number;

    /**
     * beginTime,  入学时间
     */
    private Date beginTime;
}
