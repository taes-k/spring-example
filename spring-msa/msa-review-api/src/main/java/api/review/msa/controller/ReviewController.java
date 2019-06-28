package api.review.msa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.review.msa.component.MessageProducer.WriteReviewSource;

@RestController
public class ReviewController {

	@Autowired
	WriteReviewSource writeReviewSource;
		
	@RequestMapping("/")
	public String getReview() {

		return "review Information";
	}

	@RequestMapping(value="/", method = RequestMethod.POST)
	public String setReview() {

		// set new review
		writeReviewSource.writeReview().send(MessageBuilder.withPayload("{seq : 13322}").build());
		return "write review";
	}
}