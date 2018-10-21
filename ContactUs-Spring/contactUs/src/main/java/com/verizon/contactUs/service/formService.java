package com.verizon.contactUs.service;

import java.util.List;

import com.verizon.contactUs.model.Feedback;

public interface formService {

	public void submitFeedback(Feedback fb);
	public List<Feedback> getFeedback();

	
}
