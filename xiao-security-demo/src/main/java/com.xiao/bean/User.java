package com.xiao.bean;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 〈用户〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/2 20:58
 * @since 1.0.0
 */
public class User {

    public interface UserSimpleView {};

    public interface UserDetailView extends UserSimpleView {};

    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
