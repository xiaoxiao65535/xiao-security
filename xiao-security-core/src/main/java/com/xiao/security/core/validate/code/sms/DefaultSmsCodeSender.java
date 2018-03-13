package com.xiao.security.core.validate.code.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 〈默认实现短信验证码接口〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/6 8:49
 * @since 1.0.0
 */
public class DefaultSmsCodeSender implements SmsCodeSender{

    /** logger */
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void send(String mobile, String code) {
        logger.info("向手机" + mobile + "发送验证码" + code);
    }

}
