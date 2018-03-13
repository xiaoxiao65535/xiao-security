package com.xiao.security.core.properties;

/**
 * 〈图形验证码配置〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/5 15:50
 * @since 1.0.0
 */
public class ImageCodeProperties extends SmsCodeProperties {

    private int width = 67;
    private int height = 23;

    public ImageCodeProperties() {
        setLength(4);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
