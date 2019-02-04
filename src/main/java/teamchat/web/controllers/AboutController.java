package teamchat.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(AboutController.URI)
public class AboutController {
	
	protected final static String URI="/about";

	public AboutController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping
	public String showAboutPage() {
		return "about";
		
	}

}
