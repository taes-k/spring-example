package start.mvc.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping(value="/")
	public String indexPage() {
		
		return "index";
	}
	
	@RequestMapping(value="/login")
	public String loginPage() {
		
		return "login";
	}
    
    @RequestMapping(value="/loginSuccess")
    public String loginSuccessPage() {
    
        return "loginSuccess";
    }
    
    @RequestMapping(value="/admin")
    public String adminPage() {
    
        return "admin";
    }
}
