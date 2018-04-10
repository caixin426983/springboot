package com.example.config.shiro;

import com.google.code.kaptcha.Constants;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


/**
 * 验证码过滤器
 * 此过滤器已经在shiro中配置，这里不需要再次配置拦截路径
 */
public class KaptchaFilter extends FormAuthenticationFilter {


    public static final String DEFAULT_CAPTCHA_PARAM = "captcha";


    public String captchaParam = DEFAULT_CAPTCHA_PARAM;

    /**
     * 登录验证
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        CaptchaUsernamePasswordToken token = (CaptchaUsernamePasswordToken) createToken(request, response);
        String username = token.getUsername();
        try {

        } catch (Exception e) {

            doCaptchaValidate((HttpServletRequest) request, token);
        }

        return super.executeLogin(request, response);
    }

    /**
     * 验证码校验
     */
    private void doCaptchaValidate(HttpServletRequest request, CaptchaUsernamePasswordToken token) throws IncorrectCaptchaException {
        //session中的图形码字符串
        String captcha = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        //对比
        if (captcha == null || !captcha.equalsIgnoreCase(token.getCaptcha())) {
            throw new IncorrectCaptchaException();
        }
    }

    @Override
    protected CaptchaUsernamePasswordToken createToken(ServletRequest request, ServletResponse response) {
        String username = getUsername(request);
        String password = getPassword(request);
        String captcha = getCaptcha(request);
        boolean rememberMe = isRememberMe(request);
        String host = getHost(request);
        return new CaptchaUsernamePasswordToken(username,password,toCharArray(),rememberMe,host,captcha);
    }


    public String getCaptchaParam() {
        return captchaParam;
    }

    public void setCaptchaParam(String captchaParam) {
        this.captchaParam = captchaParam;
    }

    protected String getCaptcha(ServletRequest request) {
        return WebUtils.getCleanParam(request, getCaptchaParam());
    }

    /**
     * 保存异常对象到request
     * @param request
     * @param ae
     */
    @Override
    protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
        request.setAttribute(getFailureKeyAttribute(),ae);
    }
}
