package api.review.msa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
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
	public String setReview(@RequestHeader(value="Authorization") String authorization) {

	    System.out.println("Authorization : "+authorization);
		// set new review
//		writeReviewSource.writeReview().send(MessageBuilder.withPayload("{seq : 13322}").build());
//		
		WebClient client = WebClient.builder()
		                      .baseUrl("http://localhost:8090/api/news")
		                      .defaultHeader("Authorization", authorization)
		                      .build();
		client.get().uri("/review/add?newsId=333").exchange().block();
//		client.
		return "write review";
	}
}