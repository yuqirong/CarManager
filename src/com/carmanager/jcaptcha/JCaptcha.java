/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.carmanager.jcaptcha;

import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.captchastore.FastHashMapCaptchaStore;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-3-22 下午3:46
 * <p>Version: 1.0
 */
public class JCaptcha {
    public static final MyManageableImageCaptchaService captchaService
            = new MyManageableImageCaptchaService(new FastHashMapCaptchaStore(), new GMailEngine(), 180, 100000, 75000);

    /**
     *  验证当前请求输入的验证码否正确；并从CaptchaService中删除已经生成的验证码；
     */
    public static boolean validateResponse(HttpServletRequest request, String userCaptchaResponse) {
        if (request.getSession(false) == null) return false;

        boolean validated = false;
        try {
            String id = request.getSession().getId();
            validated = captchaService.validateResponseForID(id, userCaptchaResponse).booleanValue();
        } catch (CaptchaServiceException e) {
            e.printStackTrace();
        }
        return validated;
    }
    
    /**
     * 验证当前请求输入的验证码是否正确；但不从CaptchaService中删除已经生
	 * 成的验证码（比如Ajax验证时可以使用，防止多次生成验证码）；
     */
    public static boolean hasCaptcha(HttpServletRequest request, String userCaptchaResponse) {
        if (request.getSession(false) == null) return false;
        boolean validated = false;
        try {
            String id = request.getSession().getId();
            validated = captchaService.hasCapcha(id, userCaptchaResponse);
        } catch (CaptchaServiceException e) {
            e.printStackTrace();
        }
        return validated;
    }

}
