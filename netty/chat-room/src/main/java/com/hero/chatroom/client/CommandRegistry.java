package com.hero.chatroom.client;

import com.hero.chatroom.client.command.BaseCommand;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: CommandRegistry
 * @date: 2021/1/19
 * @author: bear
 * @version: 1.0
 */
@Component
public class CommandRegistry implements BeanPostProcessor {
    private final HashMap<String, BaseCommand> commandHashMap = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof BaseCommand) {
            BaseCommand baseCommand = (BaseCommand) bean;
            commandHashMap.put(baseCommand.shortcut(), baseCommand);
        }
        return bean;
    }

    public void printCommandTable() {
        System.out.println("ShortCutKey   help");
        for (Map.Entry<String, BaseCommand> commandEntry : commandHashMap.entrySet()) {
            System.out.println(commandEntry.getValue().shortcut() + "||" + commandEntry.getValue().help());
        }
    }

    public BaseCommand getCommand(String commandKey) {
        return commandHashMap.get(commandKey);
    }
}
