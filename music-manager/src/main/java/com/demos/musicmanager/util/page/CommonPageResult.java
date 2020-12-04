package com.demos.musicmanager.util.page;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: jz
 * @Date: 2020/11/27 14:19
 * @Description: 分页查询结果
 */
@Data
public class CommonPageResult<PD> implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 接口返回信息 总记录数
     */
    private long totalCount=0;

    /**
     * 接口返回信息 总页数
     */
    private long totalPage=0;

    private long currentPage=0;
    /**
     * 返回的数据集
     */
    private List<PD> data = new ArrayList<PD>();


}
