package com.xiao.security.core.authentication.mobile;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * 〈短信验证码验证对象〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/6 11:42
 * @since 1.0.0
 */
public class SmsCodeAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = 420L;
    private final Object principal;

    public SmsCodeAuthenticationToken(String principal) {
        super(null);
        this.principal = principal;
        this.setAuthenticated(false);
    }

    public SmsCodeAuthenticationToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        } else {
            super.setAuthenticated(false);
        }
    }

}