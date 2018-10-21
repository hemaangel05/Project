package com.verizon.brs.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.brs.model.Tracking;

@Repository
public interface TrackingRepo extends JpaRepository<Tracking,String>{
	void deleteByCntNo(String cntNo);
	Optional<Tracking> findByCntNo(String cntNo);
	Optional<Tracking> findByOid(long oid);
	boolean existsByCntNo(String cntNo);
	boolean existsByOid(long oid);
	void deleteByOid(long oid);
}
