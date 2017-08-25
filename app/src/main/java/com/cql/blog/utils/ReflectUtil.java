package com.cql.blog.utils;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by home on 2017/8/25.
 */

public class ReflectUtil {
    public static <T> T getT(Object o,int index){
        Type type = o.getClass().getGenericSuperclass();
        if (!(type instanceof ParameterizedType)) {
            return null;
        }
        Type[] types = ((ParameterizedType) type).getActualTypeArguments();
        if (types.length < index) {
            return null;
        }
        @SuppressWarnings("unchecked")
        Class<T> pClass = (Class<T>) types[index];
        try {
            return pClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
