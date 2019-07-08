package com.example.demo.ResolvableTypeTest.reflect;



import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author meitu.xujun  on 2017/3/28 16:08
 * @version 0.1
 */

public class ReflectHelper {

    private static final String TAG = "ReflectHelper";

    public static Method getMethod(String className, String methodName, Class<?>... clzs) {
        try {
            Class<?> aClass = Class.forName(className);
            Method declaredMethod = aClass.getDeclaredMethod(methodName, clzs);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void printMethods(String className) {
        try {
            Class<?> aClass = Class.forName(className);
            Method[] declaredMethods = aClass.getDeclaredMethods();
            PrintUtils.print(declaredMethods);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Field getFiled(String className, String filedName) {
        Object o = null;
        try {
            Class<?> aClass = Class.forName(className);

            Field declaredField = aClass.getDeclaredField(filedName);
            //   if not public,you should call this
            declaredField.setAccessible(true);
            return declaredField;


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static Constructor getConstructor(String className, Class<?>... clzs) {
        try {
            Class<?> aClass = Class.forName(className);
            Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(clzs);
            PrintUtils.print(declaredConstructor);
            //   if Constructor is private,you should set
            declaredConstructor.setAccessible(true);
            return declaredConstructor;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void printConstructor(String className) {
        try {
            Class<?> aClass = Class.forName(className);
            Constructor<?>[] constructors = aClass.getConstructors();
            PrintUtils.print(constructors);
            Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
            PrintUtils.print(declaredConstructors);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void printFileds(String className) {
        Object o = null;
        try {
            Class<?> aClass = Class.forName(className);
            Field[] fields = aClass.getFields();
            PrintUtils.print(fields);
            Field[] declaredFields = aClass.getDeclaredFields();
            PrintUtils.print(declaredFields);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

  
}
