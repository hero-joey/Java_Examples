package com.hero.p2p;

import com.google.common.eventbus.Subscribe;

/**
 * @description: PromotionService
 * @date: 2021/3/11 9:33
 * @author: maccura
 * @version: 1.0
 */
public class PromotionService {
    @Subscribe
    public void issueNewUserExperienceCash(Long userId) {
        System.out.println("User promotion: " + userId);
    }
}
