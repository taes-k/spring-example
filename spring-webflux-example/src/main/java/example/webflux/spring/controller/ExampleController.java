package example.webflux.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import example.webflux.spring.service.ExampleService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ExampleController {
	
	@Autowired
	ExampleService exampleService;
	
	@GetMapping("/example")
	public Flux getExample() {
		Flux examples = Flux.just(exampleService.getSampleExmaple1(),
								  exampleService.getSampleExmaple2(),
								  exampleService.getSampleExmaple3(),
								  exampleService.getSampleExmaple4())
				.doOnNext(el -> System.out.println("getExample : "+el));
		
		return examples;
	}
}
