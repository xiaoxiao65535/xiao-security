package com.xiao.security.core.properties;

/**
 * 〈短信验证码配置〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/6 9:20
 * @since 1.0.0
 */
public class SmsCodeProperties {

    private int length = 6;
    private int expireIn = 60;

    private String url;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
