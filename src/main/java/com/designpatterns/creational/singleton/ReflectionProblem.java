package com.designpatterns.creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionProblem {
    public static void main(String[] args) {
        DateUtil dateUtil1 = DateUtil.getInstance();
        DateUtil dateUtil2 = null;
        Constructor[] constructors = DateUtil.class.getConstructors();
        for (Constructor constructor : constructors) {
            constructor.setAccessible(true);
            try {
                dateUtil2 = (DateUtil) constructor.newInstance();
                break;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        String s ="";
        s.isEmpty();
        System.out.println(dateUtil1.hashCode());
        System.out.println(dateUtil2.hashCode());
    }
}
