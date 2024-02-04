package com.design.patterns.creational.singleton;

import java.io.Serializable;

public class DateUtil implements Serializable, Cloneable {

    private static volatile DateUtil dateUtil;

    private DateUtil() {}
    public static  DateUtil getInstance() {
        // Lazy initialization
        if(dateUtil == null) {
            synchronized (DateUtil.class) {
                if (dateUtil == null) {
                    dateUtil = new DateUtil();
                }
            }
        }
        return dateUtil;
    }

    //To handle de-serialization issue i.e returning different object after de-serialization
    protected Object readResolve() {
        return dateUtil;
    }

    //Don't allow cloning object, then throw error by overriding clone method if anyone wants to clone
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new CloneNotSupportedException();
    }
}
