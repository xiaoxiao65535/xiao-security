package com.xiao.security.core.social.qq.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import java.io.IOException;

/**
 * 〈〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/6 22:31
 * @since 1.0.0
 */
public class QQApiImpl extends AbstractOAuth2ApiBinding implements QQApi {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";

    private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";

    private ObjectMapper objectMapper = new ObjectMapper();

    private String appId;

    private String openId;

    public QQApiImpl(String accessToken, String appId) {
        // TokenStrategy.ACCESS_TOKEN_PARAMETER 使用参数的方式
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        this.appId = appId;

        String url = String.format(URL_GET_OPENID, accessToken);
        String result = getRestTemplate().getForObject(url, String.class);

        logger.info("获取用户access_token的结果：" + result);
        this.openId = StringUtils.substringBetween(result, "\"openid\":\"", "\"}");
    }

    @Override
    public QQUserInfo getUserInfo() {

        String url = String.format(URL_GET_USERINFO, appId, openId);

        String result = getRestTemplate().getForObject(url, String.class);

        logger.info("获取用户openId的结果：" + result);

        QQUserInfo userInfo = null;

        try {
            userInfo = objectMapper.readValue(result, QQUserInfo.class);
            userInfo.setOpenId(openId);
            return userInfo;
        } catch (Exception e) {
            throw new RuntimeException("获取用户信息失败" + result, e);
        }
    }

}
