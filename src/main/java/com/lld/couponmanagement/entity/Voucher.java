package com.lld.couponmanagement.entity;

import com.lld.couponmanagement.enums.PromotionUserType;

public class Voucher extends Promotion {

    Integer id;
    Integer userId;
    Integer minAge;
    Integer minCartValue;
    Integer usageCount;
    Integer maxUsageCount;
    PromotionUserType usageUserType;
}
