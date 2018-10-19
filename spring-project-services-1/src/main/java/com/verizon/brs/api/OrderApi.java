package com.verizon.brs.api;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.brs.model.Order;
import com.verizon.brs.services.OrderService;


@RestController
@CrossOrigin
@RequestMapping("/orders")
public class OrderApi {

		@Autowired
		private OrderService orderService;

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
			if (order == null)
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else
				resp = new ResponseEntity<>(order, HttpStatus.OK);
			return resp;
		}
		
	
		@PostMapping
		public ResponseEntity<Order> addCustomerAction(@RequestBody Order order) 
		{
			ResponseEntity<Order> resp = null;
			LocalDate date = LocalDate.now().plusDays(4);
			if(date.getDayOfWeek().getValue()<3)
				date = date.plusDays(1);
			System.out.println(date);
			order.setDor(date);
			
			
			order.setPrice(orderService.calculatePrice(order.getDeliverytype(), order.getDeliveryarea(), order.getWeight(), order.getQty()));
			if (order != null && !orderService.exists(order.getOid())) {
				orderService.addOrder(order);
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
		}
		
		@DeleteMapping("/{cid}")
		public ResponseEntity<Void> deleteCustomerAction(@PathVariable("cid") int cid) {
			ResponseEntity<Void> resp = null;
			if (orderService.exists(cid)) {
				orderService.removeCustomer(cid);
				resp = new ResponseEntity<>(HttpStatus.OK);
			}
			else
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return resp;
		}
		*/
	

	
	
}
