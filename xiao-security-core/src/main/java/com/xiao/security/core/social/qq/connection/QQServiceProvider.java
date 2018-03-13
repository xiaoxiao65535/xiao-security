package com.xiao.security.core.social.qq.connection;

import com.xiao.security.core.social.qq.api.QQApi;
import com.xiao.security.core.social.qq.api.QQApiImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Template;

/**
 * 〈QQ服务提供〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/7 11:07
 * @since 1.0.0
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQApi> {

    private String appId;

    private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";

    private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";

    public QQServiceProvider(String appId, String appSecret) {
        super(new QQOAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
        this.appId = appId;
        System.out.println("创建 QQServiceProvider。。。" + this.getClass().getName());
    }

    @Override
    public QQApi getApi(String accessToken) {
        // 这里不能注入，accessToken有线程安全问题
        return new QQApiImpl(accessToken, appId);
    }

}
