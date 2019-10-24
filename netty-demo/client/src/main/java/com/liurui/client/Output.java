package com.liurui.client;

import org.springframework.stereotype.Component;

/**
 * @author liu-rui
 * @date 2019/10/23 下午2:36
 * @description
 * @since
 */
@Component
public class Output implements Outputable {
    @Override
    public void write(String msg) {
        System.out.println(msg);
    }
}
