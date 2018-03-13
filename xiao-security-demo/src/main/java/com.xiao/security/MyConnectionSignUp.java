package com.xiao.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

/**
 * 〈自定义注册逻辑〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/7 22:00
 * @since 1.0.0
 */
// @Component
public class MyConnectionSignUp implements ConnectionSignUp {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String execute(Connection<?> connection) {
        //根据社交用户信息默认创建用户并返回用户唯一标识
        logger.info("如果需要返回指定的注册页面，可以去掉该组件！");
        return connection.getDisplayName();
    }

}
