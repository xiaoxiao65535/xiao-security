package com.xiao.security.browser.support;

/**
 * 〈〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/7 15:57
 * @since 1.0.0
 */
public class SocialUserInfo {

    /**
     * 第三方平台
     */
    private String providerId;

    /**
     * 第三方平台用户openId
     */
    private String providerUserId;

    private String nickname;

    private String headimg;

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getProviderUserId() {
        return providerUserId;
    }

    public void setProviderUserId(String providerUserId) {
        this.providerUserId = providerUserId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }
}
