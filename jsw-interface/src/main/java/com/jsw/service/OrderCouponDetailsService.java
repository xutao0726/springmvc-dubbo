package com.jsw.service;

import com.jsw.entity.OrderCouponDetails;

public interface OrderCouponDetailsService {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderCouponDetails record);

    int insertSelective(OrderCouponDetails record);

    OrderCouponDetails selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderCouponDetails record);

    int updateByPrimaryKey(OrderCouponDetails record);
}
