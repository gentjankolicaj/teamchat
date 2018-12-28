package teamchat.web.controllers.thymeleaf;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/thym")
public class ThymHomeController {
	
	
	@RequestMapping({"/","index","index.xml","index.html"})
	public String showHome() {
		
		return "index";
	}
	

}
