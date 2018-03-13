package com.xiao.security.browser.support;

/**
 * 〈返回码〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/3 15:49
 * @since 1.0.0
 */
public class SimpleResponse {

    private Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

}
