package com.taizilibai.mall.handler;

import com.taizilibai.mall.domain.Response;
import com.taizilibai.mall.exception.BizException;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: zxx
 * @Date: 2020/8/20 11:31
 */
@RestControllerAdvice
@ControllerAdvice
public class GloableExceptionHandler {

    @ExceptionHandler(BizException.class)
    @ResponseBody
    public Response responseE() {
        Response response = new Response();
        response.setCode("500");
        return response;
    }
}
