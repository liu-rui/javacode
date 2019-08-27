package com.liurui;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class App {

    public enum A {
        AA(1),
        BB(2),
        ;

        public static final Map<Integer, A> Maps;

        static {
            Maps = new HashMap<>();

            for (A value : A.values()) {
                Maps.put(value.getCode(), value);
            }
        }

        private int code;

        A(int code) {
            this.code = code;
        }


        public int getCode() {
            return code;
        }

    }


    public static void main(String[] args) {

    }
}
