package com.xiao.security.core.social.qq.connection;

import com.xiao.security.core.social.qq.api.QQApi;
import com.xiao.security.core.social.qq.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * 〈qq服务适配器〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/7 11:19
 * @since 1.0.0
 */
public class QQAdapter implements ApiAdapter<QQApi> {

    @Override
    public boolean test(QQApi qqApi) {
        return true;
    }

    @Override
    public void setConnectionValues(QQApi qqApi, ConnectionValues values) {

        System.out.println("使用 ApiAdapter 适配 QQApi。。。" + this.getClass().getName());

        QQUserInfo userInfo = qqApi.getUserInfo();

        values.setDisplayName(userInfo.getNickname());
        values.setImageUrl(userInfo.getFigureurl_qq_1());
        values.setProfileUrl(null); // 设置主页url，qq没有，设置为null
        values.setProviderUserId(userInfo.getOpenId());
    }

    @Override
    public UserProfile fetchUserProfile(QQApi qqApi) {
        return null;
    }

    @Override
    public void updateStatus(QQApi qqApi, String s) {
        // 更新主页  do nothing
    }

}
