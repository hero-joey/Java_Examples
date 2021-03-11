package com.hero.designpatten.observer.p2pv2;

/**
 * @description: PromotionService
 * @date: 2021/3/11 9:33
 * @author: maccura
 * @version: 1.0
 */
public class PromotionService {
    public void issueNewUserExperienceCash(Long userId) {
        System.out.println("User promotion: " + userId);
    }
}
