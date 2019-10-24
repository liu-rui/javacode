package com.liurui.client;

/**
 * @author liu-rui
 * @date 2019/10/23 下午2:35
 * @description
 * @since
 */
public interface Outputable {
    void write(String msg);


    default void write(String format, Object... objects) {
        write(String.format(format, objects));
    }
}
