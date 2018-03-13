package com.xiao.security.core.properties;

/**
 * 〈浏览器属性配置〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/3 16:11
 * @since 1.0.0
 */
public class BrowserProperties {

    private String signUpUrl = SecurityConstants.DEFAULT_SIGN_UP_URL;

    private String loginPage = SecurityConstants.DEFAULT_LOGIN_PAGE_URL;

    private LoginType loginType = LoginType.JSON;

    private int rememberMeSecond = 3600;

    public int getRememberMeSecond() {
        return rememberMeSecond;
    }

    public void setRememberMeSecond(int rememberMeSecond) {
        this.rememberMeSecond = rememberMeSecond;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public String getSignUpUrl() {
        return signUpUrl;
    }

    public void setSignUpUrl(String signUpUrl) {
        this.signUpUrl = signUpUrl;
    }
}
