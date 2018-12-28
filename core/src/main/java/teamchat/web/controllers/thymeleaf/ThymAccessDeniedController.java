package teamchat.web.controllers.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thym/access-denied")
public class ThymAccessDeniedController {

	
	@RequestMapping({"","/","/**"})
	public String showAccessDenied() {
		
		return "access-denied";
	}
}
