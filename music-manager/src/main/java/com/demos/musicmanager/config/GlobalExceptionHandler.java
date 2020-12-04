package com.demos.musicmanager.config;

import com.demos.musicmanager.config.exception.BizException;
import com.demos.musicmanager.util.enums.ResultEnums;
import com.demos.musicmanager.util.response.ResponseData;
import com.demos.musicmanager.util.response.ResponseDataUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: jz
 * @Date: 2020/12/2 17:33
 * @Description: 异常处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理空指针异常
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseData exceptionHandler(HttpServletRequest request, NullPointerException e) {
        log.error("发生空指针异常！原因是:" + e);
        return ResponseDataUtil.buildError(ResultEnums.SYSTEM_ERROR);
    }

    /**
     * 处理自定义业务异常
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    public ResponseData bizExceptionHandler(HttpServletRequest request, BizException e) {
        log.error("发生业务异常！原因是: {}",e.getErrMsg());
        return ResponseDataUtil.buildError(e.getErrorCode(),e.getErrMsg());
    }


    /**
     * 系统其它异常
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseData exceptionHandler(HttpServletRequest request,Exception e){
        log.error("未知异常！原因是:",e);
        return ResponseDataUtil.buildError(ResultEnums.SYSTEM_ERROR);
    }

}
