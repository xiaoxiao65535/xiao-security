package com.xiao.exception;

import java.io.Serializable;

/**
 * 〈用户不存在异常〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/3 9:40
 * @since 1.0.0
 */
public class UserNotExistException extends RuntimeException {
    private static final long serialVersionUID = 2908752763044400379L;

    private String id;

    public UserNotExistException(String id) {
        super("用户不存在");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
