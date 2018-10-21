package com.verizon.brs.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.brs.dao.TrackingRepo;
import com.verizon.brs.model.Area;
import com.verizon.brs.model.Freight;
import com.verizon.brs.model.Order;
import com.verizon.brs.model.Tracking;
import com.verizon.brs.model.Type;

@Service
@Transactional
public class TrackingServiceImpl implements TrackingService {

	@Autowired
	public TrackingRepo trackingRepo;
	
	private Tracking tracking = new Tracking();
	
	@Override
	public Freight setFreight(Order order) {
		Freight freight = null;
		if (order.getDeliveryarea().equals(Area.INTERNATIONAL) && order.getDeliverytype().equals(Type.FAST)) {
			//tracking.setMode(Freight.AIR);
			freight=Freight.AIR;
			System.out.println("I,F ----> Freight ----> "+freight);
		}
		else if (order.getDeliveryarea().equals(Area.DOMESTIC) && order.getDeliverytype().equals(Type.FAST)) {
			//tracking.setMode(Freight.AIR);
			freight=Freight.AIR;
			System.out.println("D,F ----> Freight ----> "+freight);
		}
		else if (order.getDeliveryarea().equals(Area.DOMESTIC) && order.getDeliverytype().equals(Type.NORMAL)) {
			if (order.getWeight() > 1000) {
				//tracking.setMode(Freight.AIR);
				freight=Freight.AIR;
			}
			else {
				//tracking.setMode(Freight.ROAD);
				freight=Freight.ROAD;
			}
			System.out.println("D,N > Freight ----> "+freight);
		}
		else if (order.getDeliveryarea().equals(Area.INTERNATIONAL) && order.getDeliverytype().equals(Type.NORMAL)) {
			//tracking.setMode(Freight.SEA);
			freight = Freight.SEA;
			System.out.println("I,N ----> Freight ----> "+freight);
		}
		else {
			//tracking.setMode(Freight.ROAD);
			freight=Freight.ROAD;
			System.out.println("D,N ----> Freight ----> "+freight);
		}
		return freight;
	}
	
	@Override
	public void addTracking(Order order) {
		long rand = (long )(Math.random() * 1000 + 1);
		String cntNo = ""+rand; 
		/*try {
			TimeUnit.MINUTES.sleep(1);
		} catch (InterruptedException e) {
		}*/
		
		tracking.setOid(order.getOid());
		tracking.setMode(setFreight(order));
		if(tracking.getMode().equals(Freight.AIR))
			cntNo = "AV_"+cntNo;
		else if(tracking.getMode().equals(Freight.SEA))
			cntNo = "CNT_"+cntNo;
		else
			cntNo = "VL_"+cntNo;
		tracking.setCntNo(cntNo);
		tracking.setWeight(order.getWeight());
		tracking.setQty(order.getQty());
		tracking.setDelstrt(true);
		tracking.setDeldpt(false);
		trackingRepo.save(tracking);
	}
	
	@Override
	public void removeTracking(long oid) {
		if (trackingRepo.existsByOid(oid)) {
			trackingRepo.deleteByOid(oid);
			System.out.println("Tracking Delete ----> "+trackingRepo.findByOid(oid));
		}		
	}

	@Override
	public Tracking getTracking(String cntNo) {
		Optional<Tracking> opt = trackingRepo.findByCntNo(cntNo);
		return opt.isPresent() ? opt.get() : null;
	}
	
	@Override
	public Tracking getTrackingByOid(long oid) {
		Optional<Tracking> opt = trackingRepo.findByOid(oid);
		return opt.isPresent() ? opt.get() : null;
	}
	
	@Override
	public List<Tracking> getAllTrackings() {
		return trackingRepo.findAll();
	}

	@Override
	public boolean exists(String cntNo) {
		return trackingRepo.existsByCntNo(cntNo);
	}


}
