package com.verizon.brs.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.brs.dao.OrderRepo;
import com.verizon.brs.model.Order;

@Service
@Transactional
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
			System.out.println("Order Before Delete ----> "+orderRepo.findByOid(oid));
			orderRepo.deleteByOid(oid);
			System.out.println("Order After Delete ----> "+orderRepo.findByOid(oid));
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

	/*@Override
	public double calculatePrice(Type deliverytype, Area deliveryarea, double wt, int qty) {
		double price = 50.0;
		System.out.println("#1 ----> "+price);
		if (deliverytype.equals(Type.FAST)) {
			price = price * 1.5;
			System.out.println("#2 ----> "+price);
		}
		if (deliveryarea.equals(Area.INTERNATIONAL)) {
			price = price * 2;
			System.out.println("#3 ----> "+price);
		}

		if (wt > 1) {
			price = price *= wt / 2;
			System.out.println("#4 ----> "+price);
		}

		if (qty > 1) {
			price = price *= qty / 2;
			System.out.println("#5 ----> "+price);
		}
		System.out.println("#6 ----> "+price);
		return price;
	}*/

}
