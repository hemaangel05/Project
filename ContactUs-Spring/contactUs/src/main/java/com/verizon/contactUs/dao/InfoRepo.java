package com.verizon.contactUs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.contactUs.model.Info;

@Repository
public interface InfoRepo extends JpaRepository<Info, String>{
}
