package com.xiao.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * 〈〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/5 16:43
 * @since 1.0.0
 */
public interface ValidateCodeGenerator {

    ValidateCode generator(ServletWebRequest request);

}
