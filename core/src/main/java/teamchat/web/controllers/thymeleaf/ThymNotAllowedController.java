package teamchat.web.controllers.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thym/**")
public class ThymNotAllowedController {

	
	@RequestMapping({"","/","/**"})
	public String showNotAllowed() {
		
		return "not-allowed";
	}
}
