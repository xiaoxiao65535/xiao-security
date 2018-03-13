package com.xiao.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * 〈QQ属性配置〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/7 12:50
 * @since 1.0.0
 */
public class QQProperties extends SocialProperties {

    private String providerId = "qq";

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

}
