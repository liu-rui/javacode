package com.liurui.client;

import com.liurui.client.command.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Scanner;

/**
 * @author liu-rui
 * @date 2019/10/23 下午2:16
 * @description
 * @since
 */
@Component
public class ConsoleRunner implements Runnable {
    @Autowired
    Map<String, Command> commandMap;

    @PostConstruct
    public void init() {
        Thread thread = new Thread(this);

        thread.start();
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            final String msg = scanner.nextLine();

            if (execCommand(msg)) {
                continue;
            }
            System.out.println(msg);
        }
    }

    private boolean execCommand(String msg) {
        for (Map.Entry<String, Command> entry : commandMap.entrySet()) {
            if (entry.getValue().exec(msg)) {
                return true;
            }
        }
        return false;
    }

}
