package client.config.cloud.spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Value("${taeseong.profile}")
	private String testkey;
	
	@RequestMapping("/")
	public String test() {
		
		return "{testkey : "+testkey+" }";
	}
}
