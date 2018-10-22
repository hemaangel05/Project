package com.verizon.abt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.abt.dao.CInfo;
import com.verizon.abt.model.ClInfo;

@Service
public class ClInfoServiceImpl implements ClInfoService{
	
	@Autowired
	private CInfo clinfo;

	@Override
	public List<ClInfo> getInformation() {
		
		return clinfo.findAll();
	}

}
