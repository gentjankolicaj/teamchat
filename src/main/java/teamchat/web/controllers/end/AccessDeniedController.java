package teamchat.web.controllers.end;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/access-denied")
public class AccessDeniedController {

	
	@RequestMapping({"","/","/**"})
	public String showAccessDenied() {
		
		return "access-denied";
	}
}
