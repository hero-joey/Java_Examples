package com.hero.p2p;

import com.google.common.eventbus.Subscribe;

/**
 * @description: RegisterPromotionObserver
 * @date: 2021/3/11 9:41
 * @author: maccura
 * @version: 1.0
 */
public class RegisterPromotionObserver {
    private PromotionService promotionService;

    public RegisterPromotionObserver(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @Subscribe
    public void handleRegisterSuccess(Long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}
