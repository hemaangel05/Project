package com.verizon.abt.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.abt.model.ClInfo;
import com.verizon.abt.service.ClInfoService;


@RestController
@CrossOrigin
@RequestMapping("/clinfo")

public class ClInfoApi {
	@Autowired
	ClInfoService iservice;
	
	
	@GetMapping
	public ResponseEntity<List<ClInfo>> getInformation() {
		return new ResponseEntity<>(iservice.getInformation(), HttpStatus.OK);

	}


}
