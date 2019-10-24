package com.liurui.server.service;

import com.daling.framework.ReturnData;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liu-rui
 * @date 2019/10/23 上午11:38
 * @description
 * @since
 */
@Service
public class IndexServiceImpl implements IndexService {
    @Override
    public ReturnData login(String name) {
        return ReturnData.success();
    }

    @Override
    public ReturnData<List<String>> all() {
        return ReturnData.success(Lists.newArrayList("a", "b"));
    }
}
