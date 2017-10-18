package com.github.javacode.jvm;

/**
 * 测试堆分配
 * @author liurui
 *
 * -Xmx20m -Xms5m
 */
public class MTest {
    public static void main(String[] args) {
        print();

        byte[] b = new byte[1 * 1024 * 1024];
        print();
        byte[] c = new byte[1 * 1024 * 1024];
        print();
        System.gc();
        print();
    }

    private static void print() {
        System.out.printf("max:%f free:%f total:%f\n", Runtime.getRuntime().maxMemory() / 1024.0 / 1024,
                Runtime.getRuntime().freeMemory() / 1024.0 / 1024,
                Runtime.getRuntime().totalMemory() / 1024.0 / 1024
        );
    }

}
