package com.jsw.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsw.entity.OrderCoupon;
import com.jsw.mapper.OrderCouponMapper;
import com.jsw.service.OrderCouponService;

@Service
public class OrderCouponServiceImpl implements OrderCouponService {
	@Autowired
	private OrderCouponMapper orderCouponMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(OrderCoupon record) {
		return orderCouponMapper.insert(record);
	}

	@Override
	public int insertSelective(OrderCoupon record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OrderCoupon selectByPrimaryKey(Integer id) {
		return orderCouponMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(OrderCoupon record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(OrderCoupon record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
