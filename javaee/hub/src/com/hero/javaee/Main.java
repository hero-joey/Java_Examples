package com.hero.javaee;

import com.hero.javaee.topicHandler.DispatchHandler;
import com.hero.javaee.topicHandler.DispatchMessageHandler;

public class Main {

    public static void main(String[] args) {
	// write your code here
        DispatchMessageHandler dispatchMessageHandler = new DispatchMessageHandler();
        dispatchMessageHandler.dispatchMessage("image");
        dispatchMessageHandler.dispatchMessage("onlineupgrade");
    }
}
