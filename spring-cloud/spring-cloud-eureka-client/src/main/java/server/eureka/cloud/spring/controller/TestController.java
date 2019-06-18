package server.eureka.cloud.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class TestController {

	@RequestMapping("/test")
	public String test(){
		
		return "TEST GOOD";
	}
}
