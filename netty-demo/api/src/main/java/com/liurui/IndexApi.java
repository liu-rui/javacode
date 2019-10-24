package com.liurui;

import com.daling.framework.ReturnData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author liu-rui
 * @date 2019/10/23 上午11:36
 * @description
 * @since
 */
public interface IndexApi {
    @GetMapping("/login")
    ReturnData login(@RequestParam String name);

    @GetMapping("/all")
    ReturnData<List<String>> all();
}
