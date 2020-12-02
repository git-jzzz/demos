package com.demos.begindemo.util.page;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Collections;
import java.util.List;

/**
 * @author: jz
 * @Date: 2020/11/26 16:41
 * @Description:  分页工具转换
 */
public class PageUtils {
    public static <T> Page<T> toPage(PageQueryRequest pageRequest) {
        return new Page<>(pageRequest.getCurrentPage(), pageRequest.getPageSize());
    }


    public static <T> CommonPageResult<T> toPageResult(Page<T> page, List<T> dataList) {
        int totalCount = (int) page.getTotal();
        int totalPage = ConverterUtil.calculateTotalPage((int)page.getSize(), totalCount);
        List<T> data;
        if (CollectionUtils.isEmpty(dataList)) {
            data = Collections.emptyList();
        } else {
            data = dataList;
        }
        return ConverterUtil.convertToPageResult(data, totalCount, totalPage,page.getCurrent());
    }
}
