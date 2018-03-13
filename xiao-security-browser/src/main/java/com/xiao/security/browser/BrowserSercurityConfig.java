package com.xiao.security.browser;

import com.xiao.security.core.authentication.AbstractChannelSecurityConfig;
import com.xiao.security.core.properties.SecurityConstants;
import com.xiao.security.core.validate.code.ValidateCodeSecurityConfig;
import com.xiao.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.xiao.security.core.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;


/**
 * 〈BS架构安全配置〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/3 14:12
 * @since 1.0.0
 */
@Configuration
public class BrowserSercurityConfig extends AbstractChannelSecurityConfig {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    @Autowired
    private SpringSocialConfigurer mySpringSocialConfigurer;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        System.out.println("加载 BrowserSercurityConfig。。。" + this.getClass().getName());

        applyPasswordAuthenticationConfig(http);

        http.apply(validateCodeSecurityConfig)
                .and()
            .apply(smsCodeAuthenticationSecurityConfig)
                .and()
            .apply(mySpringSocialConfigurer)
                .and()
            .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSecond())
                .userDetailsService(userDetailsService)
                .and()
            .authorizeRequests()
                .antMatchers(
                        SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                        SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
                        securityProperties.getBrowser().getLoginPage(),
                        securityProperties.getBrowser().getSignUpUrl(),
                        "/user/regist"
                ).permitAll()       // 不做权限拦截
                .anyRequest()       // 任何请求
                .authenticated()    // 都需要身份认证
                .and()
            .csrf().disable();      // 关闭跨站防护攻击

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 如果有自己的密码加密方式，需要实现PasswordEncoder接口
        System.out.println("加载 PasswordEncoder（自定义密码加密方式）。。。" + this.getClass().getName());
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        System.out.println("加载 PersistentTokenRepository（自定义记住我功能的数据库信息）。。。" + this.getClass().getName());
        JdbcTokenRepositoryImpl persistentTokenRepository = new JdbcTokenRepositoryImpl();
        persistentTokenRepository.setDataSource(dataSource);
        // persistentTokenRepository.setCreateTableOnStartup(true);
        return persistentTokenRepository;
    }

}
