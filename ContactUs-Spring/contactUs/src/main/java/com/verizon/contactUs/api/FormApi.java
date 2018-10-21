package com.verizon.contactUs.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.contactUs.model.Feedback;
import com.verizon.contactUs.service.formService;

@RestController
@CrossOrigin
@RequestMapping("fbform")
public class FormApi {

	@Autowired
	formService fservice;
	
	
	
	@GetMapping
	public ResponseEntity<List<Feedback>> listFeedbackAction() {
		ResponseEntity<List<Feedback>> resp = null;
		List<Feedback> fback = fservice.getFeedback();
		if (fback != null && fback.size() > 0)
			resp = new ResponseEntity<List<Feedback>>(fback, HttpStatus.OK);
		else
			resp = new ResponseEntity<List<Feedback>>(HttpStatus.NOT_FOUND);
		return resp;
	}

	
	@PostMapping
	public ResponseEntity<Feedback> addFeedbackAction(@RequestBody Feedback fb) {
		ResponseEntity<Feedback> resp = null;
		
		
		if (fb != null  ) {
			fservice.submitFeedback(fb);
			resp = new ResponseEntity<Feedback>(fb, HttpStatus.OK);
		}
		else
			resp = new ResponseEntity<Feedback>(HttpStatus.CONFLICT);

		return resp;
	}
}
