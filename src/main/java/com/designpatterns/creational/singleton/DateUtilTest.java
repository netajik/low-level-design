package com.design.patterns.creational.singleton;

import java.io.*;

public class DateUtilTest {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        DateUtil dateUtil1 = DateUtil.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
                new File("C:\\Users\\kanch\\Documents\\practice\\java\\dateutil.txt")));
        oos.writeObject(dateUtil1);

        //de-searilization
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File("C:\\Users\\kanch\\Documents\\practice\\java\\dateutil.txt")));

        DateUtil dateUtil2 = (DateUtil) ois.readObject();
        oos.close();
        ois.close();
        System.out.println(dateUtil1 == dateUtil2);
    }
}
