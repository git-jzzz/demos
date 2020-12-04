package com.demos.musicmanager.util.page;

import com.demos.musicmanager.constants.CommonApiConstants;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: jz
 * @Date: 2020/11/26 16:30
 * @Description:  分页查询请求类
 */
@ToString(callSuper = true)
public class PageQueryRequest implements Serializable {
    private static final long serialVersionUID =1L;

    /**
     * currentPage 当前页
     */
    @Setter
    private Integer currentPage;

    /**
     * pageSize 每页显示的条数
     */
    @Setter
    private Integer pageSize;

    public Integer getCurrentPage(){
        return this.currentPage == null || this.currentPage <= 0 ? CommonApiConstants.DEFAULT_CURRENT_PAGE : this.currentPage;
    }

    /**
     * 默认为10，最大值为100，防止被外界乱调用
     * @return
     */
    public Integer getPageSize(){
        return this.pageSize == null || this.pageSize <= 0 ? CommonApiConstants.DEFAULT_PAGE_SIZE : Math.min(this.pageSize, CommonApiConstants.DEFAULT_MAX_PAGE_SIZE);
    }

}
