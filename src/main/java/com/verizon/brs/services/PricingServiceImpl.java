package com.verizon.brs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.brs.dao.PricingRepo;
import com.verizon.brs.model.Area;
import com.verizon.brs.model.Freight;
import com.verizon.brs.model.Order;
import com.verizon.brs.model.Pricing;
import com.verizon.brs.model.Type;

@Service
public class PricingServiceImpl implements PricingService {
	
	private Pricing pricing = new Pricing();
	double price = 50.0;
	double cancelcharges = 0.0;
	boolean isCancel = false;

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
	public double calculatePrice(Order order) {
	//Freight freight;
		System.out.println("#1 ----> "+price);

		if (order.getWeight() > 1) {
			price = price *= order.getWeight() / 2;
			System.out.println("#2 ----> "+price);
		}

		if (order.getQty() > 1) {
			price = price *= order.getQty() / 2;
			System.out.println("#3 ----> "+price);
		}
		
		if (order.getDeliveryarea().equals(Area.INTERNATIONAL) && order.getDeliverytype().equals(Type.FAST)) {
			price = price * 3; 
			pricing.setFreight(Freight.AIR);
			//freight=Freight.AIR;
			System.out.println("#4 ----> "+price);
			System.out.println("Freight : "+pricing.getFreight());
		}
		else if (order.getDeliveryarea().equals(Area.DOMESTIC) && order.getDeliverytype().equals(Type.FAST)) {
			price = price * 2;
			pricing.setFreight(Freight.AIR);
			//freight=Freight.AIR;
			System.out.println("#5 ----> "+price);
			System.out.println("Freight : "+pricing.getFreight());
		}
		else if (order.getDeliveryarea().equals(Area.DOMESTIC) && order.getDeliverytype().equals(Type.NORMAL)) {
			price = price * 2;
			if (order.getWeight() > 1000)
				pricing.setFreight(Freight.AIR);
			else
				pricing.setFreight(Freight.ROAD);
			//freight=Freight.AIR;
			System.out.println("#5 ----> "+price);
			System.out.println("Freight : "+pricing.getFreight());
		}
		else if (order.getDeliveryarea().equals(Area.INTERNATIONAL) && order.getDeliverytype().equals(Type.NORMAL)) {
			price = price * 2;
			pricing.setFreight(Freight.SEA);
			//freight = Freight.AIR;
			System.out.println("#6 ----> "+price);
			System.out.println("Freight : "+pricing.getFreight());
		}
		else {
			pricing.setFreight(Freight.ROAD);
			//freight=Freight.ROAD;
		}
		
		if(isCancel) {
			price = price*0.1;
			cancelcharges = price;
		}
		System.out.println("#7 ----> "+price);
		/*pricing.setOid(oid);
		pricing.setDeliverytype(deliverytype);
		pricing.setDeliveryarea(deliveryarea);
		pricing.setPrice(price);
		pricing.setCancel(isCancel);
		pricing.setCancelcharges(0);
		System.out.println("#7 ----> "+price);
		Pricing pricing = new Pricing(oid,freight,deliverytype,deliveryarea,price,isCancel,cancelcharges);
		priceRepo.save(pricing);
		System.out.println("Pricing : "+pricing.toString());*/
		return price;
	}

	@Override
	public void addPricing(Order order) {
		pricing.setOid(order.getOid());
		pricing.setDeliverytype(order.getDeliverytype());
		pricing.setDeliveryarea(order.getDeliveryarea());
		pricing.setPrice(price);
		pricing.setCancel(isCancel);
		pricing.setCancelcharges(cancelcharges);
		priceRepo.save(pricing);
	}

}
