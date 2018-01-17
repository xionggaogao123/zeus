package com.zeus.common.util;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import java.util.Collection;

/**
 * @author keven
 * @date 2018-01-15 下午2:38
 * @Description
 */
public class Arguments {

    public static <T extends Collection> boolean isNullOrEmpty(T t) {
        return isNull(t) || isEmpty(t);
    }

    public static boolean isNull(Object o) {
        return o == null;
    }

    public static boolean notNull(Object o) {
        return o != null;
    }

    public static boolean isEmpty(String s) {
        return Strings.isNullOrEmpty(s);
    }

    public static <T extends Collection> boolean isEmpty(T t) {
        return t.isEmpty();
    }

    public static boolean notEmpty(String s) {
        return !isEmpty(s);
    }

    public static <T extends Collection> boolean notEmpty(T l) {
        return notNull(l) && !l.isEmpty();
    }

    public static boolean positive(Number n) {
        return n.doubleValue() > 0.0D;
    }

    public static boolean isPositive(Number n) {
        return n != null && n.doubleValue() > 0.0D;
    }

    public static boolean negative(Number n) {
        return n.doubleValue() < 0.0D;
    }

    public static boolean isNegative(Number n) {
        return n != null && n.doubleValue() < 0.0D;
    }

    public static <T> boolean equalWith(T source, T target) {
        return Objects.equal(source, target);
    }

    public static boolean not(Boolean t) {
        Preconditions.checkArgument(notNull(t));
        return !t;
    }

    public static boolean isDecimal(String str) {
        char[] var1 = str.toCharArray();
        for (char c : var1) {
            if (c < 48 || c > 57) {
                return false;
            }
        }
        return true;
    }

}
