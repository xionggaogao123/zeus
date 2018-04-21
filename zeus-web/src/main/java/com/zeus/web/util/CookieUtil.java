package com.zeus.web.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author keven
 * @date 2018-04-21 上午9:57
 * @Description
 */
public class CookieUtil {


    public static final String CK_TOKEN = "_s_token_";

    public static final String CK_DEVICE_ID = "_s_device_id_";


    public static String getCookie(String key, HttpServletRequest request) {
        if (request == null || StringUtils.isBlank(key)) {
            return null;
        }
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie != null && key.equals(cookie.getName())) {
                    try {
                        return URLDecoder.decode(cookie.getValue(), "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        // do nothing
                    }
                }
            }
        }
        return null;
    }

    public static void setCookie(String key, String value, Integer maxAge, HttpServletRequest request,
                                 HttpServletResponse response) {
        Cookie cookie = new Cookie(key, value);
        cookie.setDomain(getCookieDomain(request));
        cookie.setPath("/");
        if (maxAge != null) {
            cookie.setMaxAge(maxAge);
        }
        response.addCookie(cookie);
    }

    public static String getCookieDomain(HttpServletRequest request) {
        String domain = request.getServerName();
        int indexOf = domain.indexOf(".");
        return domain.substring(indexOf, domain.length());
    }


    public static String getDeviceCookie(HttpServletRequest request) {
		return getCookie(CK_DEVICE_ID, request);
    }





}
