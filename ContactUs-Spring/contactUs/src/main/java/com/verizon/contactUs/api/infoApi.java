package com.verizon.contactUs.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.verizon.contactUs.model.Info;
import com.verizon.contactUs.service.infoService;

@RestController
@CrossOrigin
@RequestMapping("/info")

public class infoApi {

	
	@Autowired
	infoService iservice;
	
	
	@GetMapping
	public ResponseEntity<List<Info>> getInformation() {
		return new ResponseEntity<>(iservice.getInformation(), HttpStatus.OK);

	}

}
