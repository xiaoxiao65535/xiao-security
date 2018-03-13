package com.xiao.security.core.validate.code.sms;

import com.xiao.security.core.properties.SecurityProperties;
import com.xiao.security.core.validate.code.ValidateCode;
import com.xiao.security.core.validate.code.ValidateCodeGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 〈短信验证码生成器〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/6 9:12
 * @since 1.0.0
 */
@Component("smsCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ValidateCode generator(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        return new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());
    }

}
