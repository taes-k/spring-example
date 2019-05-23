package example.mvc.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import example.mvc.spring.service.ExampleService;

@Controller
public class ExampleController {

    @Autowired
    private ExampleService exampleService;

    @RequestMapping(value="/example", method = RequestMethod.GET)
	public String example(Model model) {
    	
    	model.addAttribute("data",exampleService.getExample());
    	
		return "example";
	}
}
