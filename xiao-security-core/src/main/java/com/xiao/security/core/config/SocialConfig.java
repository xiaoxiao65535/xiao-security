package com.xiao.security.core.config;

import com.xiao.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

/**
 * 〈第三方登录配置〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/7 11:30
 * @since 1.0.0
 */
@Configuration
@Order(1)
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired(required = false)
    private ConnectionSignUp connectionSignUp;

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
        repository.setTablePrefix("xiao_"); // 表的前缀
        if (connectionSignUp != null) {
            // 如果有connectionSignUp的实现，就设置这个东西
            repository.setConnectionSignUp(connectionSignUp);
        }
        System.out.println("指定UsersConnectionRepository（社交登录用户信息存储策略）。。。" + this.getClass().getName());
        return repository;
    }

    @Bean
    public SpringSocialConfigurer mySpringSocialConfigurer() {
        MySpringSocialConfigurer socialConfigurer = new MySpringSocialConfigurer(securityProperties.getSocial().getAuthUrl());
        // 设置注册页面
        socialConfigurer.signupUrl(securityProperties.getBrowser().getSignUpUrl());
        return socialConfigurer;
    }

    /**
     * 社交登录的时候
     *
     * @param connectionFactoryLocator
     * @return
     */
    @Bean
    public ProviderSignInUtils providerSignInUtils(ConnectionFactoryLocator connectionFactoryLocator) {
        return new ProviderSignInUtils(connectionFactoryLocator,
                getUsersConnectionRepository(connectionFactoryLocator)) {
        };
    }
}
