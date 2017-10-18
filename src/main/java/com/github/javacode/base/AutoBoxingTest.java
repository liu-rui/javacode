package com.github.javacode.base;

/**
 * 测试自动装箱，自动拆箱
 * 编译器帮忙做了，具体查看target/classes
 */
public class AutoBoxingTest {
    public static void main(String[] args) {
        //等于 Integer a = Integer.valueOf(1000);
        Integer a = 1000;
        //等于int b = (new Integer(1000)).intValue();
        int b = new Integer(1000);
    }
}
