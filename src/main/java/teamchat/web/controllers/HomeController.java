package teamchat.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(HomeController.URI)
public class HomeController {
	
	protected final static String URI="/home";
	
	
	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}


	@RequestMapping
	public String showHome() {
		return "home";
	}
	

}
