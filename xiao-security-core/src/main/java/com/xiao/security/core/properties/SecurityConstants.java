package com.xiao.security.core.properties;

/**
 * 〈安全配置常量〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/6 16:55
 * @since 1.0.0
 */
public interface SecurityConstants {

    /**
     * 默认注册页面
     */
    String DEFAULT_SIGN_UP_URL = "/xiao-signUp.html";

    /**
     * 默认登录页面
     */
    String DEFAULT_LOGIN_PAGE_URL = "/xiao-signIn.html";

    /**
     * 当请求需要身份认证是，默认跳转的url
     *
     * @see SecurityProperties
     */
    String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";

    /**
     * 默认的用户名密码登录请求处理url
     */
    String DEFAULT_LOGIN_PROCESSING_URL_FORM = "/authentication/form";

    /**
     * 默认的手机验证码登录请求处理url
     */
    String DEFAULT_LOGIN_PROCESSING_URL_MOBILE = "/authentication/mobile";

    /**
     * 默认的处理验证码的url前缀
     */
    String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";

    /**
     * 验证短信验证码时，http请求中默认的携带短信验证码信息的参数的名称
     */
    String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";

    /**
     * 验证图片验证码时，http请求中默认的携带图片验证码信息的参数的名称
     */
    String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";
}
