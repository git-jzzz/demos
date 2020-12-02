package com.demos.begindemo.pojo.entity;

import lombok.Data;

import java.io.Serializable;

/**
* grade : 年级表
*/
@Data
public class Grade  implements Serializable {

private static final long serialVersionUID = 1L;

        /**
        * 主键 : id,  年级id
        */
        private Integer id;

        /**
        * gradeName,  年级名
        */
        private String gradeName;

public Grade(Integer id,String gradeName){
    this.id = id;
    this.gradeName = gradeName;
}

public Grade(){
}


}