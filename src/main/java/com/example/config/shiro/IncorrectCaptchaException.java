package com.example.config.shiro;

import javax.naming.AuthenticationException;

/**
 * 验证码错误异常
 */
public class IncorrectCaptchaException extends AuthenticationException {


    private static final long serialVersionUID = 8825087743566360410L;


    public IncorrectCaptchaException() {
        super();
    }

    public IncorrectCaptchaException(String message) {
        super(message);
    }


}
