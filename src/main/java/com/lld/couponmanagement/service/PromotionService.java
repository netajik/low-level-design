package com.lld.couponmanagement.service;

import com.lld.couponmanagement.entity.Cart;
import com.lld.couponmanagement.entity.Promotion;
import com.lld.couponmanagement.entity.User;
import com.lld.couponmanagement.enums.PromotionStatus;
import com.lld.couponmanagement.enums.PromotionUserType;

import java.util.List;

public interface PromotionService {

     Promotion createPromotion(Promotion coupon);

     List<Promotion> getPromotion(String userId, PromotionStatus status, PromotionUserType usageUserType);

     Promotion deletePromotion(Integer promotionId);

     Promotion updateStatus(Integer promotionId, PromotionStatus status);

     List<Promotion> getPromotions();

     boolean PromotionService(User user, Cart cart, String promotionCode);

     void incrementPromotionUsageCount(String promotionCode);

     boolean isValidPromotion(String promotionCode);
}
