package com.qy.reflect;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>Project:</b> Sample <br>
 * <b>Create Date:</b> 2018/2/5 <br>
 * <b>@author:</b> qy <br>
 * <b>Address:</b> qingyongai@gmail.com <br>
 * <b>Description:</b>  <br>
 */
public class ReflectionSample {

    private static List<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        // 就是如果这个方法在当前类里面有，都可以拿到
        // 定义的pub pro pri，pro继承，pub继承，impl的接口的都可以
        Method[] methods = IFImpl.class.getDeclaredMethods();
        // 只能拿public的，获取当前类存在的public方法，或者父类里面的public方法
        Method[] methods2 = IFImpl.class.getMethods();

        ClassPool pool = ClassPool.getDefault();

        System.out.println(methods.length + "===" + methods2.length);

        try {
            CtClass ctClass = pool.get("com.qy.reflect.IFImpl");
            // 这个和上面的getDeclaredMethods一样
            CtMethod[] methods3 = ctClass.getDeclaredMethods();
            // 这个有点不一样，除了public的，还会拿到protected的
            CtMethod[] methods4 = ctClass.getMethods();

            // CtMethod method = ctClass.getMethod("goIngo", null);

            System.out.println(methods3.length + "===" + methods4.length);

            // System.out.println(method);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

}
