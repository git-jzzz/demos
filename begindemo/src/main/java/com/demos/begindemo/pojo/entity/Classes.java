package com.demos.begindemo.pojo.entity;

import lombok.Data;

import java.io.Serializable;

/**
* classes : 班级表
*/
@Data
public class Classes  implements Serializable {

private static final long serialVersionUID = 1L;

        /**
        * 主键 : id,  班级id
        */
        private Integer id;

        /**
        * className,  班级名
        */
        private String className;

        /**
        * gradeId,  年级id
        */
        private Integer gradeId;

public Classes(Integer id,String className,Integer gradeId){
    this.id = id;
    this.className = className;
    this.gradeId = gradeId;
}

public Classes(){
}


}