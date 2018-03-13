package com.xiao.security.core.properties;

/**
 * 〈社交属性配置〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/7 12:52
 * @since 1.0.0
 */
public class SocialProperties {

    private String authUrl = "/auth";

    private QQProperties qq;

    private WeixinProperties weixin;

    public QQProperties getQq() {
        return qq;
    }

    public void setQq(QQProperties qq) {
        this.qq = qq;
    }

    public WeixinProperties getWeixin() {
        return weixin;
    }

    public void setWeixin(WeixinProperties weixin) {
        this.weixin = weixin;
    }

    public String getAuthUrl() {
        return authUrl;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }
}
