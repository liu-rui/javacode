package com.liurui.client.command;

import com.alibaba.fastjson.JSON;
import com.daling.framework.ReturnData;
import com.liurui.IndexApi;
import com.liurui.client.Outputable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liu-rui
 * @date 2019/10/23 下午2:50
 * @description
 * @since
 */
@Component("loginCommand")
@Order(2)
public class LoginCommand implements Command {
    private static final Pattern pattern = Pattern.compile(":login\\s+(\\w+)");
    @Autowired
    Outputable outputable;
    @Autowired
    IndexApi indexApi;


    @Override
    public String desc() {
        return ":login name 登录；name为登录名";
    }

    @Override
    public boolean exec(String msg) {
        final Matcher matcher = pattern.matcher(msg);

        if (!matcher.find()) {
            return false;
        }
        final String name = matcher.group(1);
        final ReturnData ret = indexApi.login(name);

        if (ret.isSuccess()) {
            outputable.write("欢迎您，%s", name);
        } else {
            outputable.write("登录失败，返回值为%s", JSON.toJSONString(ret));
        }
        return true;
    }
}
