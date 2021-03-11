package com.hero.p2p;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        RegisterPromotionObserver registerPromotionObserver = new RegisterPromotionObserver(new PromotionService());
        RegisterNotificationObserver registerNotificationObserver = new RegisterNotificationObserver(new NotificationService());
        UserController userController = new UserController(new UserService());
        userController.setObservers(Arrays.asList(registerPromotionObserver, registerNotificationObserver));

        userController.register("daxiong", "123456");
    }
}
