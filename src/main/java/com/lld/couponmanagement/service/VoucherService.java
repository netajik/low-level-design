package com.lld.couponmanagement.service;

import com.lld.couponmanagement.entity.Cart;
import com.lld.couponmanagement.entity.Promotion;
import com.lld.couponmanagement.entity.User;
import com.lld.couponmanagement.enums.PromotionStatus;
import com.lld.couponmanagement.enums.PromotionUserType;

import java.util.List;

public class VoucherService implements PromotionService{
    @Override
    public Promotion createPromotion(Promotion coupon) {
        return null;
    }

    @Override
    public List<Promotion> getPromotion(String userId, PromotionStatus status, PromotionUserType usageUserType) {
        return null;
    }

    @Override
    public Promotion deletePromotion(Integer promotionId) {
        return null;
    }

    @Override
    public Promotion updateStatus(Integer promotionId, PromotionStatus status) {
        return null;
    }

    @Override
    public List<Promotion> getPromotions() {
        return null;
    }

    @Override
    public boolean PromotionService(User user, Cart cart, String promotionCode) {
        return false;
    }

    @Override
    public void incrementPromotionUsageCount(String promotionCode) {

    }

    @Override
    public boolean isValidPromotion(String promotionCode) {
        return false;
    }
}
