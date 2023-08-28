package com.lld.couponmanagement.entity;

import com.lld.couponmanagement.enums.PromotionUserType;

import java.util.Date;

public class Coupon {
    Integer id;
    Integer userId;
    Integer minCartValue;
    Integer cartValue;
    Integer usageCount;
    Integer maxUsageCount;
    Date expiryDate;
    PromotionUserType promotionUserType;
}
