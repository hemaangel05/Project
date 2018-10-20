package com.verizon.brs.services;

import java.util.List;

import com.verizon.brs.model.Order;

public interface OrderService {
	public void addOrder(Order order);
	public void removeOrder(long oid);
	public void updateOrder(Order order);
	public Order getOrder(long oid);
	public List<Order> getAllOrders();
	
	public boolean exists(long cid);
	//double calculatePrice(Type deliverytype,Area deliveryarea,double wt, int qty);


}
