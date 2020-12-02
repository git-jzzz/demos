package com.demos.begindemo.pojo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* student : 学生信息表
*/
@Data
public class Student  implements Serializable {

private static final long serialVersionUID = 1L;

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
        * number,  学号
        */
        private String number;

        /**
        * beginTime,  入学时间
        */
        private Date beginTime;

public Student(Integer id,String name,Integer sex,Integer age,String address,Integer classId,String number,Date beginTime){
    this.id = id;
    this.name = name;
    this.sex = sex;
    this.age = age;
    this.address = address;
    this.classId = classId;
    this.number = number;
    this.beginTime = beginTime;
}

public Student(){
}


}