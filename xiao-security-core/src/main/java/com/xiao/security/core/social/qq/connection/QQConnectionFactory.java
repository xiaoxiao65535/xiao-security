package com.xiao.security.core.social.qq.connection;

import com.xiao.security.core.social.qq.api.QQApi;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.oauth2.OAuth2ServiceProvider;

/**
 * 〈qq连接工厂〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/7 11:24
 * @since 1.0.0
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQApi> {

    public QQConnectionFactory(String providerId, String appId, String appSecret) {
        super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
        System.out.println("创建 QQConnectionFactory。。。" + this.getClass().getName());
    }

}
