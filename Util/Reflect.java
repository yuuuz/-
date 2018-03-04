package com.yuuuzh.Util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 2018/2/13 14:55
 */
public class Reflect {
    private static final String SET = "set";
    private static final String GET = "get";
    public static boolean invokeSetMethod(Object object, Field field, String value) {
        Class<? extends Object> clazz = object.getClass();
        Method method = invokeMethod(clazz, field.getName(), SET, field.getType());
        try {
            method.invoke(object, transfer(field.getType(), value));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static Method invokeMethod(Class<?> clazz, String fieldName, String type, Class<?> ...parameterTypes) {
        if(null == clazz) {
            return null;
        }
        if(null == fieldName) {
            return null;
        }
        if(!type.equals(SET) && !type.equals(GET)) {
            return null;
        }
        String methodName = type + fieldName.substring(0, 1).toUpperCase()+ fieldName.substring(1);
        return invokeMethod(clazz, methodName, parameterTypes);
    }

    public static Method invokeMethod(Class<?> clazz, String methodName, Class<?> ...parameterTypes) {
        if(null == clazz) {
            return null;
        }
        if(null == methodName) {
            return null;
        }
        Method method = null;
        try {
            method = clazz.getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return method;
    }
    public static List<Field> fieldNames(Class<?> clazz) {
        if(null == clazz) {
            return null;
        }
        Field []fields = clazz.getDeclaredFields();
        if(0 >= fields.length) {
            return null;
        }
        return  Arrays.asList(fields);
    }

    public static List<Field> fieldNamesWithSuper(Class<?> clazz) {
        if(null == clazz) {
            return null;
        }
        List<Field> fields = new ArrayList<>();
        fields.addAll(fieldNames(clazz));
        fields.addAll(fieldNames(clazz.getSuperclass()));

        return fields;
    }

    private static Object transfer(Class<?> type, String value) throws Exception {
        if(type.equals(int.class) || type.equals(Integer.class)) {
            return Integer.parseInt(value);

        }
        if(type.equals(float.class) || type.equals(Float.class)) {
            return Double.parseDouble(value);
        }
        if(type.equals(double.class) || type.equals(Double.class)) {
            return Double.parseDouble(value);
        }
        if(type.equals(boolean.class) || type.equals(Boolean.class)) {
            return Boolean.parseBoolean(value);
        }
        if(type.equals(Date.class)) {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            return format.parse(value);
        }
        return value;
    }

}
