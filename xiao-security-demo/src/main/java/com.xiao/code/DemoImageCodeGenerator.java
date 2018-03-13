package com.xiao.code;

import com.xiao.security.core.validate.code.image.ImageCode;
import com.xiao.security.core.validate.code.ValidateCodeGenerator;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 〈更高级的图形验证码〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/5 17:01
 * @since 1.0.0
 */
// @Component("imageCodeGenerator")
@Component
public class DemoImageCodeGenerator implements ValidateCodeGenerator{

    @Override
    public ImageCode generator(ServletWebRequest request) {
        System.out.println("更高级的图形验证码");
        return null;
    }

}
