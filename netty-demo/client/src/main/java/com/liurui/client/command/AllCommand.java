package com.liurui.client.command;

import com.daling.framework.ReturnData;
import com.google.common.base.Strings;
import com.liurui.IndexApi;
import com.liurui.client.Outputable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author liu-rui
 * @date 2019/10/23 下午3:27
 * @description
 * @since
 */
@Component("allCommand")
@Order(3)
public class AllCommand implements Command {
    @Autowired
    IndexApi indexApi;
    @Autowired
    Outputable outputable;

    @Override
    public String desc() {
        return ":all 列出所有的用户";
    }

    @Override
    public boolean exec(String msg) {
        if (!":all".contentEquals(msg)) {
            return false;
        }
        final ReturnData<List<String>> ret = indexApi.all();

        if (ret.isSuccess()) {
            outputable.write("所有的用户:%s", StringUtils.collectionToDelimitedString(ret.getData(), ","));
        } else {
            outputable.write("获取所有用户失败！");
        }
        return true;
    }
}
