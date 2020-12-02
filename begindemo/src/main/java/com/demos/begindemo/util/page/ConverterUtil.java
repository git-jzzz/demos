package com.demos.begindemo.util.page;

import java.util.List;

/**
 * @author: jz
 * @Date: 2020/11/27 14:17
 * @Description: 分页转换
 */
public class ConverterUtil {




    public static int calculateTotalPage(int pageSize, int totalCount) {
        int totalPage = totalCount / pageSize + ((totalCount % pageSize == 0) ? 0 : 1);
        return totalPage;
    }



    public static <T> CommonPageResult<T> convertToPageResult(List<T> data, long totalCount, long totalPage,long currentPage) {
        CommonPageResult<T> pageResult = new CommonPageResult<T>();
        pageResult.setTotalCount(totalCount);
        pageResult.setTotalPage(totalPage);
        pageResult.setCurrentPage(currentPage);
        if (data != null) {
            pageResult.setData(data);
        }
        return pageResult;
    }
}
