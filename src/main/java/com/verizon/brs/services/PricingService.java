package com.verizon.brs.services;

import java.util.List;

import com.verizon.brs.model.Area;
import com.verizon.brs.model.Order;
import com.verizon.brs.model.Pricing;
import com.verizon.brs.model.Type;

public interface PricingService {
	public void addPricing(Order order);
	public Pricing getPricing(long oid);
	public List<Pricing> getAllPrices();
	public boolean exists(long cid);
	public double calculatePrice(Order order);
	//double calculatePrice(Type deliverytype,Area deliveryarea,double weight, int qty, boolean isCancel);
}
