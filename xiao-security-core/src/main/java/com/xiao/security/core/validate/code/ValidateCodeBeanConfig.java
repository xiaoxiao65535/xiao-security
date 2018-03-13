package com.xiao.security.core.validate.code;

import com.xiao.security.core.properties.SecurityProperties;
import com.xiao.security.core.validate.code.ValidateCodeGenerator;
import com.xiao.security.core.validate.code.image.ImageCodeGenerator;
import com.xiao.security.core.validate.code.sms.DefaultSmsCodeSender;
import com.xiao.security.core.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈验证码配置〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/5 16:52
 * @since 1.0.0
 */
@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator() {
        ImageCodeGenerator imageCodeGenerator = new ImageCodeGenerator();
        imageCodeGenerator.setSecurityProperties(securityProperties);
        return imageCodeGenerator;
    }

    @Bean
    @ConditionalOnMissingBean(name = "smsCodeSender")
    public SmsCodeSender smsCodeSender() {
        return new DefaultSmsCodeSender();
    }

}
