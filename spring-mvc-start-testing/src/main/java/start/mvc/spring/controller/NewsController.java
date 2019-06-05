package start.mvc.spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import start.mvc.spring.service.MainNewsServiceImpl;

@RestController
public class NewsController {

	@Autowired
	MainNewsServiceImpl mainNewsService;
	
	@RequestMapping("/news")
	public Map<String,Object> index(Model model) {
		Map<String,Object> result = new HashMap<>();
		
    	result.put("code", 200);
    	result.put("result", mainNewsService.getNews());
    	
		return result;
	}
}
