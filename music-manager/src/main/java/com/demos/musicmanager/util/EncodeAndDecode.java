package com.demos.musicmanager.util;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author: jz
 * @Date: 2020/12/3 13:47
 * @Description: 编码解码
 */
@Slf4j
public class EncodeAndDecode {
    public static String encode(String parameter,String coded){//parameter---字符串参数，coded---编码格式例如utf-8
        log.info("--EncodeAndDecode--encode--statr--parameter="+parameter+"--coded="+coded);
        if(StringUtils.isNotBlank(parameter)&&StringUtils.isNotBlank(coded)){
            try {
                parameter = URLEncoder.encode(parameter,coded);
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                log.error("--EncodeAndDecode--encode--Exception--"+e);
            }
            log.info("--EncodeAndDecode--encode--end");
        }
        return parameter;
    }
    /**
     * 解码
     */
    public static String decode(String parameter,String coded){//parameter---编码后的字符串参数，coded---编码格式例如utf-8
        log.info("--EncodeAndDecode--decode--statr--parameter="+parameter+"--coded="+coded);
        if(StringUtils.isNotBlank(parameter)&&StringUtils.isNotBlank(coded)){
            try {
                parameter = URLDecoder.decode(parameter,coded);
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                log.error("--EncodeAndDecode--decode--Exception--"+e);
            }
            log.info("--EncodeAndDecode--decode--end");
        }
        return parameter;

    }

}
