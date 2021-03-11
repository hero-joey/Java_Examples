package com.hero.designpatten.observer.p2pv2;

/**
 * @description: RegisterPromotionObserver
 * @date: 2021/3/11 9:41
 * @author: maccura
 * @version: 1.0
 */
public class RegisterPromotionObserver implements RegisterObserver {
    private PromotionService promotionService;

    @Override
    public void handleRegisterSuccess(Long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}
