package com.jsw.service;

import com.jsw.entity.OrderCoupon;

public interface OrderCouponService {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderCoupon record);

    int insertSelective(OrderCoupon record);

    OrderCoupon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderCoupon record);

    int updateByPrimaryKey(OrderCoupon record);
}
