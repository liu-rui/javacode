package com.github.javacode.jvm;


/**
 * -Xmx20m -Xms20m -Xmn7m -XX:+PrintGCDetails
 */
public class HuiShouTest {
    public static void main(String[] args) {
        byte[] b = null;

        for(int i = 0;i<10;i++) {
            b = new byte[1 * 1024 * 1024];
            System.out.println(i);
        }
    }
}
