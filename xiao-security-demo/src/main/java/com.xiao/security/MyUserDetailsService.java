package com.xiao.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;
import sun.util.resources.cldr.mg.LocaleNames_mg;

/**
 * 〈用户认证〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/3 14:41
 * @since 1.0.0
 */
@Component
public class MyUserDetailsService implements UserDetailsService, SocialUserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 表单登录
     *
     * @param username 表单账号
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("表单登录用户名：" + username);
        // 根据用户名查询用户信息，权限
        // 判断用户是否被冻结
        String password = passwordEncoder.encode("123456");
        logger.info("数据库密码是：" + password);
        return new User(username,
                password,
                true,
                true,
                true,
                true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        logger.info("社交用户登录id：" + userId);
        // 根据用户名查询用户信息，权限
        // 判断用户是否被冻结
        String password = passwordEncoder.encode("123456");
        logger.info("数据库密码是：" + password);
        return new SocialUser(userId,
                password,
                true,
                true,
                true,
                true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
