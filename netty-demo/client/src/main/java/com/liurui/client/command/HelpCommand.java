package com.liurui.client.command;

import com.liurui.client.Outputable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author liu-rui
 * @date 2019/10/23 下午2:31
 * @description
 * @since
 */
@Component("helpCommand")
@Order(1)
public class HelpCommand implements Command {
    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    Outputable outputable;

    @Override
    public String desc() {
        return ":h 获取帮助";
    }

    @Override
    public boolean exec(String msg) {
        if (!":h".contentEquals(msg)) {
            return false;
        }
        final Map<String, Command> commandMap = applicationContext.getBeansOfType(Command.class);

        for (Map.Entry<String, Command> entry : commandMap.entrySet()) {
            outputable.write(entry.getValue().desc());
        }
        return true;
    }
}
