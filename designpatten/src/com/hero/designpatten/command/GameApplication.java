package com.hero.designpatten.command;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: GameApplication
 * @date: 2021/3/26 10:02
 * @author: maccura
 * @version: 1.0
 */
public class GameApplication {
    private static final int MAX_HANDLED_REQ_COUNT_PER_LOOP = 100;
    private Queue<Command> queue = new LinkedList<>();

    public void mainloop() {
        while (true) {
            List<Request> requests = new ArrayList<>();
            //省略从epoll或者select中获取数据，并封装成Request的逻辑，
            //注意设置超时时间，如果很长时间没有接收到请求，就继续下面的逻辑处理。
            for (Request request : requests) {
                Event event = request.getEvent();
                Command command = null;
                if (event.equals(Event.GOT_DIAMOND)) {
                    /*数据作为参数*/
                    command = new GotDiamondCommand(request.getData());
                } else if (event.equals(Event.GOT_STAR)) {
                    command = new GotStarCommand(request.getData());
                } else if (event.equals(Event.HIT_OBSTACLE)) {
                    command = new HitObstacleCommand(request.getData());
                } else if (event.equals(Event.ARCHIVE)) {
                    command = new ArchiveCommand(request.getData());
                } // ...一堆else if...
                queue.add(command);
            }

            int handledCount = 0;
            while (handledCount < MAX_HANDLED_REQ_COUNT_PER_LOOP) {
                if (queue.isEmpty()) {
                    break;
                }

                Command command = queue.poll();
                command.execute();
            }
        }
    }
}
