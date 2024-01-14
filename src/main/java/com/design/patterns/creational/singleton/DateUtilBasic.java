package com.design.patterns.creational.singleton;

public class DateUtilBasic {

    private static volatile DateUtilBasic dateUtilBasic;
    /**
     * eager initialization
     * If the object of the class used atleast once in the project then we can use eager initialization
     */
//    private static DateUtilBasic dateUtilBasic = new DateUtilBasic();
//    static {
//        dateUtil = new DateUtil();
//    }

    private DateUtilBasic() {}

    static DateUtilBasic getInstance() {
        // Lazy initialization
        if(dateUtilBasic == null){
            synchronized(DateUtilBasic.class) {
                if(dateUtilBasic == null){
                    dateUtilBasic = new DateUtilBasic();
                }
            }
        }
        return dateUtilBasic;
    }
}
