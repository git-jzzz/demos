package com.demos.begindemo.service;

import com.demos.begindemo.util.response.ResponseData;

/**
 * @author: jz
 * @Date: 2020/11/30 13:57
 * @Description: 视频去水印
 */
public interface RemoveWMService {
    ResponseData rmwm(String url) throws Exception;
}
