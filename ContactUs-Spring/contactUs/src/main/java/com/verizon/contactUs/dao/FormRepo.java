package com.verizon.contactUs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.contactUs.model.Feedback;

@Repository
public interface FormRepo  extends JpaRepository<Feedback, String>{

}
