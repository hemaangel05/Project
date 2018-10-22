package com.verizon.abt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.abt.model.ClInfo;

@Repository
public interface CInfo extends JpaRepository<ClInfo, String>{

}
