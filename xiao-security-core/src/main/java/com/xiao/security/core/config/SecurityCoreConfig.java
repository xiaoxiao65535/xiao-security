package com.xiao.security.core.config;

import com.xiao.security.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 〈属性加载配置〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/3 16:14
 * @since 1.0.0
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
}
