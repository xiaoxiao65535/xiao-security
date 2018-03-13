package com.xiao.security.core.validate.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 〈验证码图片控制器〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/3 22:30
 * @since 1.0.0
 */
@RestController
public class ValidateCodeController {

    /**
     * spring依赖查找，收集系统中所有{@link ValidateCodeProcessor}接口实现。
     */
    @Autowired
    private Map<String, ValidateCodeProcessor> validateCodeProcessors;

    /**
     * 创建验证码，根据验证码类型不同，调用{@link ValidateCodeProcessor}接口实现
     *
     * @param request
     * @param response
     * @param codeType 请求类型
     * @throws IOException
     */
    @GetMapping("/code/{codeType}")
    public void createCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String codeType) throws Exception {
        validateCodeProcessors.get(codeType + "CodeProcessor").create(new ServletWebRequest(request, response));
    }

}
