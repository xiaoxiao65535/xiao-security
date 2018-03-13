package com.xiao.web.controller;

import com.xiao.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈Controller异常处理器〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/3 9:54
 * @since 1.0.0
 */
@ControllerAdvice  // 这个注解是处理其他Controller抛出来的异常
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handlerUserNotException(UserNotExistException ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", ex.getId());
        map.put("message", ex.getMessage());
        return map;
    }

}
