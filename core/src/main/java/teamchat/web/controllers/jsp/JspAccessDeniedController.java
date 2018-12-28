package teamchat.web.controllers.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp/access-denied")
public class JspAccessDeniedController {

	
	@RequestMapping({"","/","/**"})
	public String showAccessDenied() {
		
		return "access-denied";
	}
}
