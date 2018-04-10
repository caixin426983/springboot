package com.example.config.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;


/**
 * 拓展登录验证字段
 */
public class CaptchaUsernamePasswordToken extends UsernamePasswordToken {


    private static final long serialVersionUID = 6583245830743792756L;


    /**
     * 验证码字符串
     */
    private String captcha;


    public CaptchaUsernamePasswordToken(String username, char[] password, boolean remeberMe, String host, String captcha) {
        super(username, password, remeberMe, host);
        this.captcha = captcha;
    }


    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
