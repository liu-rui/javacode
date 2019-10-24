package com.liurui.client.command;

/**
 * @author liu-rui
 * @date 2019/10/23 下午2:27
 * @description
 * @since
 */
public interface Command {
    String desc();

    boolean exec(String msg);
}
