package com.verizon.brs.services;

import java.util.List;

import com.verizon.brs.model.Freight;
import com.verizon.brs.model.Order;
import com.verizon.brs.model.Pricing;

public interface PricingService {
	public void addPricing(Order order);
	public void removePricing(long oid);
	public Pricing getPricing(long oid);
	public List<Pricing> getAllPrices();
	public boolean exists(long oid);
	public double calculatePrice(Order order,Freight freight);
	//double calculatePrice(Type deliverytype,Area deliveryarea,double weight, int qty, boolean isCancel);
}
