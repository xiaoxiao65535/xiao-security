package com.xiao.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * 〈图片验证码异常〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/3 23:59
 * @since 1.0.0
 */
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = 2969741417807698867L;

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
