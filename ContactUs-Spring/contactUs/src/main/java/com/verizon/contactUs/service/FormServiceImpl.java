package com.verizon.contactUs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.contactUs.dao.FormRepo;
import com.verizon.contactUs.model.Feedback;

@Service
public class FormServiceImpl implements formService {

	@Autowired
	private FormRepo frepo;
	@Override
	public void submitFeedback(Feedback fb) {
		frepo.save(fb);
	}
	@Override
	public List<Feedback> getFeedback() {
		List<Feedback> plans = frepo.findAll();
		return plans;
	}

}
