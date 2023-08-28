package com.lld.couponmanagement.service;

import com.lld.couponmanagement.entity.Cart;
import com.lld.couponmanagement.entity.Promotion;
import com.lld.couponmanagement.entity.User;
import com.lld.couponmanagement.enums.PromotionStatus;
import com.lld.couponmanagement.enums.PromotionUserType;

import java.util.List;

public class CouponService implements PromotionService{
    @Override
    public Promotion createPromotion(Promotion coupon) {
        //save in db.
        return null;
    }

    @Override
    public List<Promotion> getPromotion(String userId, PromotionStatus status, PromotionUserType usageUserType) {
        //fetch all the active coupuns with give userid and userType as 'all'
        return null;
    }

    @Override
    public Promotion deletePromotion(Integer promotionId) {
        //delete the coupon from db
        return null;
    }

    @Override
    public Promotion updateStatus(Integer promotionId, PromotionStatus status) {
        //mark coupon as inactive/active
        return null;
    }

    @Override
    public List<Promotion> getPromotions() {
        //return all the coupons
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
        //check if exist in db
        return false;
    }
}
