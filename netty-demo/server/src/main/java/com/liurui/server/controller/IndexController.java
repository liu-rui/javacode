package com.liurui.server.controller;

import com.daling.framework.ReturnData;
import com.liurui.IndexApi;
import com.liurui.server.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liu-rui
 * @date 2019/10/23 上午11:11
 * @description
 * @since
 */
@RestController
public class IndexController implements IndexApi {
    @Autowired
    IndexService indexService;

    @Override
    public ReturnData login(String name) {
        return indexService.login(name);
    }

    @Override
    public ReturnData<List<String>> all() {
        return indexService.all();
    }
}
