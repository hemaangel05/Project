package com.verizon.brs.api;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.brs.model.Freight;
import com.verizon.brs.model.Order;
import com.verizon.brs.model.Pricing;
import com.verizon.brs.model.Tracking;
import com.verizon.brs.services.OrderService;
import com.verizon.brs.services.PricingService;
import com.verizon.brs.services.TrackingService;


@RestController
@CrossOrigin
@RequestMapping("/orders")
public class OrderApi {

		@Autowired
		private OrderService orderService;
		
		@Autowired
		private PricingService pricingService;
		
		@Autowired
		private TrackingService trackingService;

		@GetMapping
		public ResponseEntity<List<Order>> listCustomersAction() {
			ResponseEntity<List<Order>> resp = null;
			List<Order> orders = orderService.getAllOrders();
			if (orders != null && orders.size() >= 0)
				resp = new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
			else
				resp = new ResponseEntity<List<Order>>(HttpStatus.NOT_FOUND);
			return resp;
		}

		@GetMapping("/{oid}")
		public ResponseEntity<Order> getCustomerAction(@PathVariable("oid") Long oid) {
			ResponseEntity<Order> resp = null;
			Order order = orderService.getOrder(oid);
			//Tracking tracking = trackingService.getTrackingByOid(oid);
			if (order == null)
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else {
				//getTrackingAction(oid);
				resp = new ResponseEntity<>(order, HttpStatus.OK);
			}
			return resp;
		}
		
	
		@PostMapping
		public ResponseEntity<Order> addCustomerAction(@RequestBody Order order,Pricing pricing,Tracking tracking) 
		{
			ResponseEntity<Order> resp = null;
			LocalDate date = LocalDate.now().plusDays(4);
			if(date.getDayOfWeek().getValue()<3)
				date = date.plusDays(1);
			System.out.println("---------------------------------------------------------------------------------------------------");
			System.out.println(date);
			order.setDor(date);
			Freight freight = trackingService.setFreight(order);
			System.out.println("None ----> Freight ----> "+freight);
			order.setPrice(pricingService.calculatePrice(order,freight));
			if (order != null && !orderService.exists(order.getOid())) {
				orderService.addOrder(order);
				System.out.println("Order ----> "+order);
				//System.out.println("Order ----> "+order.toString());
				//pricingService.calculatePrice(order.getDeliverytype(), order.getDeliveryarea(), order.getWeight(), order.getQty(), pricing.isCancel());
				pricingService.addPricing(order);
				pricing = pricingService.getPricing(order.getOid());
				System.out.println("Pricing ----> "+pricing);
				//pricingService.addPricing(pricing);
				trackingService.addTracking(order);
				tracking = trackingService.getTrackingByOid(order.getOid());
				System.out.println("Tracking ----> "+tracking);
				resp = new ResponseEntity<Order>(order, HttpStatus.OK);
			}
			else
				resp = new ResponseEntity<Order>(HttpStatus.CONFLICT);

			return resp;
			
		}
		
		
		
		
		
		
		/*
		@PutMapping
		public ResponseEntity<Order> updateCustomerAction(@RequestBody Order order) {
			ResponseEntity<Order> resp = null;

			if (order != null && orderService.exists(order.getCid())) {
				orderService.updateCustomer(order);
				resp = new ResponseEntity<>(order, HttpStatus.OK);
			}
			else 
				resp = new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
			return resp;
		}*/
		
		@DeleteMapping("/{oid}")
		public ResponseEntity<Void> deleteCustomerAction(@PathVariable("oid") long oid) {
			ResponseEntity<Void> resp = null;
			if (orderService.exists(oid)) {
				pricingService.removePricing(oid);
				trackingService.removeTracking(oid);
				orderService.removeOrder(oid);
				resp = new ResponseEntity<>(HttpStatus.OK);
			}
			else
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return resp;
		}
		
	
		
		/*@GetMapping("/{oid}")
		public ResponseEntity<?> getCustomerAction(@PathVariable("oid") Long oid) {
			ResponseEntity<?> resp = null;
			Order order = orderService.getOrder(oid);
			if (order == null)
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else {
				getTrackingAction(oid);
				resp = new ResponseEntity<>(order, HttpStatus.OK);
				resp.
			}
			return resp;
		}
		
		public ResponseEntity<Tracking> getTrackingAction(@PathVariable("oid") Long oid) {
			ResponseEntity<Tracking> resp = null;
			Tracking tracking = trackingService.getTrackingByOid(oid);
			if (tracking == null)
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else {
				getTrackingAction(oid);
				resp = new ResponseEntity<>(tracking, HttpStatus.OK);
			}
			return resp;
		}*/
	
	
}
