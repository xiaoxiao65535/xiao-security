package com.xiao.security.core.validate.code;


import org.springframework.web.context.request.ServletWebRequest;

/**
 * 〈验证码数据处理类〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/6 9:32
 * @since 1.0.0
 */
public interface ValidateCodeProcessor {

    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_CODE_";

    /**
     * 创建校验码
     *
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;

    /**
     * 校验验证码
     *
     * @param servletWebRequest
     * @throws Exception
     */
    void validate(ServletWebRequest servletWebRequest);
}
