package com.jsw.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsw.entity.OrderCouponDetails;
import com.jsw.mapper.OrderCouponDetailsMapper;
import com.jsw.service.OrderCouponDetailsService;
@Service
public class OrderCouponDetailsServiceImpl implements OrderCouponDetailsService{
	
	@Autowired
	
	private OrderCouponDetailsMapper orderCouponDetailsMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(OrderCouponDetails record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(OrderCouponDetails record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OrderCouponDetails selectByPrimaryKey(Integer id) {
		return orderCouponDetailsMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(OrderCouponDetails record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(OrderCouponDetails record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
