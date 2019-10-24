package com.liurui.server.service;

import com.daling.framework.ReturnData;

import java.util.List;

/**
 * @author liu-rui
 * @date 2019/10/23 上午11:27
 * @description
 * @since
 */
public interface IndexService {
    ReturnData login(String name);

    ReturnData<List<String>> all();
}
