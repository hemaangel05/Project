package com.verizon.brs.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.brs.model.Order;
import com.verizon.brs.model.Pricing;

@Repository
public interface PricingRepo extends JpaRepository<Pricing, Long>{
	void deleteByOid(long oid);
	Optional<Order> findByOid(long oid);
	boolean existsByOid(long oid);
}
