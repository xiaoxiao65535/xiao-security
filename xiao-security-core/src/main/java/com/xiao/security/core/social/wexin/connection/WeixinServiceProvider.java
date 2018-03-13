package com.xiao.security.core.social.wexin.connection;

import com.xiao.security.core.social.qq.connection.QQAdapter;
import com.xiao.security.core.social.wexin.api.WeixinApi;
import com.xiao.security.core.social.wexin.api.WeixinApiImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

/**
 * 微信的OAuth2流程处理器的提供器，供spring social的connect体系调用
 *
 * @author zhailiang
 */
public class WeixinServiceProvider extends AbstractOAuth2ServiceProvider<WeixinApi> {

    /**
     * 微信open获取授权码的url
     */
    // private static final String URL_AUTHORIZE = "https://open.weixin.qq.com/connect/qrconnect";
    /**
     * 微信公众号获取授权码的url
     */
    private static final String URL_AUTHORIZE = "https://open.weixin.qq.com/connect/oauth2/authorize";
    /**
     * 微信获取accessToken的url
     */
    private static final String URL_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token";

    /**
     * @param appId
     * @param appSecret
     */
    public WeixinServiceProvider(String appId, String appSecret) {
        super(new WeixinOAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
        System.out.println("创建 WeixinServiceProvider。。。");
    }

    @Override
    public WeixinApi getApi(String accessToken) {
        return new WeixinApiImpl(accessToken);
    }

}
