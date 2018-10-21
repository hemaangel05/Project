package com.verizon.brs.services;

import java.util.List;

import com.verizon.brs.model.Freight;
import com.verizon.brs.model.Order;
import com.verizon.brs.model.Tracking;

public interface TrackingService {
	public void addTracking(Order order);
	public void removeTracking(long oid);
	public Tracking getTracking(String cntNo);
	public Tracking getTrackingByOid(long oid);
	public List<Tracking> getAllTrackings();
	public Freight setFreight(Order order);
	public boolean exists(String cntNo);
	//double calculatePrice(Type deliverytype,Area deliveryarea,double wt, int qty);


}
