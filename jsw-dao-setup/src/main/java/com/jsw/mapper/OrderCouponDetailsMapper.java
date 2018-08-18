package com.jsw.mapper;

import com.jsw.entity.OrderCouponDetails;

public interface OrderCouponDetailsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderCouponDetails record);

    int insertSelective(OrderCouponDetails record);

    OrderCouponDetails selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderCouponDetails record);

    int updateByPrimaryKey(OrderCouponDetails record);
}