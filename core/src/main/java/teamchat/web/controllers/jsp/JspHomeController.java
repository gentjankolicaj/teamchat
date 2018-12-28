package teamchat.web.controllers.jsp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/jsp")
public class JspHomeController {
	
	
	@RequestMapping({"/","index","index.xml","index.html"})
	public String showHome() {
		
		return "index";
	}
	

}
