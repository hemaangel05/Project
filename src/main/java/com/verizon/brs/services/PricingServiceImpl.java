package com.verizon.brs.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.brs.dao.PricingRepo;
import com.verizon.brs.model.Freight;
import com.verizon.brs.model.Order;
import com.verizon.brs.model.Pricing;

@Service
@Transactional
public class PricingServiceImpl implements PricingService {
	
	private Pricing pricing = new Pricing();

	@Autowired
	public PricingRepo priceRepo;

	@Override
	public Pricing getPricing(long oid) {
		Optional<Pricing> opt = priceRepo.findById(oid);
		return opt.isPresent() ? opt.get() : null;
	}

	@Override
	public List<Pricing> getAllPrices() {
		return priceRepo.findAll();
	}

	@Override
	public boolean exists(long oid) {
		return priceRepo.existsByOid(oid);
	}

	@Override
	//public double calculatePrice(Type deliverytype, Area deliveryarea, double weight, int qty, boolean isCancel) {
	public double calculatePrice(Order order, Freight freight) {
	//Freight freight;
		double price = 50.0;
		System.out.println("#1 ----> "+price);

		if (order.getWeight() > 1 && order.getWeight()<1000) {
			price = price *= order.getWeight() / 2;
			System.out.println("#2 < ----> "+price);
		} else {
			price = 25000.0;
			System.out.println("#2 > ----> "+price);
		}
		if (order.getQty() > 1) {
			price = price *= order.getQty() / 2;
			System.out.println("#3 ----> "+price);
		}
		if(freight.equals(Freight.AIR)) {
			price = price * 2;
			System.out.println("#4 ----> "+price);
		}
		else if(freight.equals(Freight.SEA)) {
			price = price * 1.5;
			System.out.println("#5 ----> "+price);
		}
		else
			System.out.println("#6 ----> "+price);
		
		
		return price;
	}

	@Override
	public void addPricing(Order order) {
		boolean isCancel = false;
		double price = order.getPrice();
		double cancelcharges = 0.0;
		pricing.setOid(order.getOid());
		pricing.setDeliverytype(order.getDeliverytype());
		pricing.setDeliveryarea(order.getDeliveryarea());
		if(isCancel) {
			price = price*0.1;
			cancelcharges = price;
		}
		pricing.setPrice(price);
		System.out.println("#7 ----> "+price);
		pricing.setCancel(isCancel);
		pricing.setCancelcharges(cancelcharges);
		priceRepo.save(pricing);
	}
	
	@Override
	public void removePricing(long oid) {
		if (priceRepo.existsByOid(oid)) {
			priceRepo.deleteByOid(oid);
			System.out.println("Pricing Delete ----> "+priceRepo.findByOid(oid));
		}			
	}

}
