package com.xiao.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 〈安全配置〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/3 16:11
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "xiao.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    private ValidateCodeProperties code = new ValidateCodeProperties();

    private SocialProperties social = new SocialProperties();

    public SecurityProperties() {
        System.out.println("加载 SecurityProperties。。。" + this.getClass().getName());
    }

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    public SocialProperties getSocial() {
        return social;
    }

    public void setSocial(SocialProperties social) {
        this.social = social;
    }

}
