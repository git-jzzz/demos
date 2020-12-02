package com.demos.begindemo.pojo.bo;

import com.demos.begindemo.util.page.PageQueryRequest;
import lombok.Data;

/**
 * @author: jz
 * @Date: 2020/11/27 13:33
 * @Description:
 */
@Data
public class StudentBO  extends PageQueryRequest {

    private String name;
}
