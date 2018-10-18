package com.verizon.brs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.brs.dao.OrderRepo;
import com.verizon.brs.model.Area;
import com.verizon.brs.model.Order;
import com.verizon.brs.model.Type;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	public OrderRepo orderRepo;

	@Override
	public void addOrder(Order order) {
		orderRepo.save(order);

	}

	@Override
	public void removeOrder(long oid) {
		if (orderRepo.existsByOid(oid)) {
			orderRepo.deleteByOid(oid);
		}

	}

	@Override
	public void updateOrder(Order order) {
		if (orderRepo.existsByOid(order.getOid())) {
			orderRepo.save(order);
		}

	}

	@Override
	public Order getOrder(long oid) {
		Optional<Order> opt = orderRepo.findByOid(oid);
		return opt.isPresent() ? opt.get() : null;
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}

	@Override
	public boolean exists(long oid) {
		return orderRepo.existsByOid(oid);
	}

	@Override
	public double calculatePrice(Type deliverytype, Area deliveryarea, double wt, int qty) {
		double price = 50.0;
		if (deliverytype.equals("FAST")) {
			price = price * 1.5;
		}
		if (deliveryarea.equals("INTERNATIONAL")) {
			price = price * 2;
		}

		if (wt > 1) {
			price = price *= wt / 2;
		}

		if (qty > 1) {
			price = price *= qty / 2;
		}
		return price;
	}

}
