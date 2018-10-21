package com.verizon.contactUs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.contactUs.dao.InfoRepo;
import com.verizon.contactUs.model.Info;

@Service
public class infoServiceImpl implements infoService {

	@Autowired
	private InfoRepo irepo;
	
	@Override
	public List<Info> getInformation() {
		return irepo.findAll();
	}

}
