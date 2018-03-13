package com.xiao.security.core.config;

import com.xiao.security.core.properties.QQProperties;
import com.xiao.security.core.properties.SecurityProperties;
import com.xiao.security.core.social.qq.connection.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

/**
 * 〈QQ属性装配配置〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/7 12:59
 * @since 1.0.0
 */
@Configuration
@ConditionalOnProperty(prefix = "xiao.security.social.qq", name = "app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        System.out.println("初始化 QQConnectionFactory。。。" + this.getClass().getName());
        QQProperties qq = securityProperties.getSocial().getQq();
        return new QQConnectionFactory(qq.getProviderId(), qq.getAppId(), qq.getAppSecret());
    }

}
