package com.zeus.user.api.constant;

/**
 * @author keven
 * @date 2018-04-15 下午11:46
 * @Description
 */
public enum LoginType {


    NAME(1),
    EMAIL(2),
    MOBILE(3),
    OTHER(4);

    private final int type;

    LoginType(int type) {
        this.type = type;
    }

    public static LoginType fromValue(int value) {
        for (LoginType loginType : LoginType.values()) {
            if (loginType.type == value) {
                return loginType;
            }
        }
        throw new IllegalArgumentException("illegal login type: " + value);
    }
}
