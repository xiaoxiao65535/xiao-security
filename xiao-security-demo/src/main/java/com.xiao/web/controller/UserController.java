package com.xiao.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.xiao.bean.User;
import com.xiao.bean.UserQueryCondition;
import com.xiao.exception.UserNotExistException;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈用户服务〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/2 20:54
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());


    private ProviderSignInUtils providerSignInUtils;

    @Autowired
    public void setProviderSignInUtils(ProviderSignInUtils providerSignInUtils) {
        System.out.println("加载 ProviderSignInUtils" + this.getClass().getName());
        this.providerSignInUtils = providerSignInUtils;
    }

    @PostMapping(value = "/regist")
    public void regist(User user, HttpServletRequest request) {
        // 注册用户
        // 不管是注册用户还是绑定用户，都会拿到一个用户唯一标识。
        logger.info("此处需要实现注册逻辑");
        String userId = user.getUsername();

        // 将userId传给Spring Social ,将用户信息写入数据库
        providerSignInUtils.doPostSignUp(userId, new ServletWebRequest(request));
    }

    @GetMapping(value = "/me")
    public Object getCurrentUser(@AuthenticationPrincipal UserDetails user) {
        return user;
    }

    @PutMapping(value = "/{id:\\d+}")
    public void updateUser(@Valid @RequestBody User user, BindingResult errors) {

        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> {
                        FieldError fieldError = (FieldError) error;
                        String message = fieldError.getField() + error.getDefaultMessage();
                        logger.info("表单校验异常：" + message);
                    }
            );
        }

        System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));

    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user, BindingResult errors) {

        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }

        System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
        return user;
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> getAll(UserQueryCondition userQueryCondition,
                             @PageableDefault(page = 2, size = 5, sort = "username,asc") Pageable pageable) {
        System.out.println(ReflectionToStringBuilder.toString(userQueryCondition, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(ReflectionToStringBuilder.toString(pageable, ToStringStyle.MULTI_LINE_STYLE));
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping(value = "/{id:\\d+}")
    @JsonView(User.UserSimpleView.class)
    public User getUserByid(@PathVariable String id) {

//        if (true) {
//            throw new UserNotExistException(id);
//        }

        System.out.println("进入getUserByid服务");
        User user = new User();
        user.setUsername("12312");
        user.setPassword("1235645");
        return user;
    }


}
