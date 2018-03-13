package com.xiao.security.core.validate.code.sms;

/**
 * 〈短信验证码发送接口〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/6 8:48
 * @since 1.0.0
 */
public interface SmsCodeSender {

    void send(String mobile, String code);

}
