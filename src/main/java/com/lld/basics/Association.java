package com.lld.basics;

/**
 * An association is a relationship between two class
 *
 */
class A {
    void show() {
        System.out.println("class A");
    }
}

class B extends A {
    @Override
    void show() {
        System.out.println("class B");
    }
}

public class Association {
    public static void main(String args[]) {
        A a = new A();
        B a1 = new B();
        a.show();
        a1.show();
        System.out.println(a instanceof B);
    }
}
