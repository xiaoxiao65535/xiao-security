package com.xiao.security.core.validate.code.image;

import com.xiao.security.core.validate.code.ValidateCode;

import java.awt.image.BufferedImage;

/**
 * 〈图形验证码〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/3 22:14
 * @since 1.0.0
 */
public class ImageCode extends ValidateCode {

    private BufferedImage image;

    public ImageCode(BufferedImage image, String code, int expireIn) {
        super(code, expireIn);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

}
