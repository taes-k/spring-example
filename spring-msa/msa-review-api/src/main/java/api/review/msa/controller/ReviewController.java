package api.review.msa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {

	@RequestMapping("/")
	public String getReview() {

		return "review Information";
	}
}