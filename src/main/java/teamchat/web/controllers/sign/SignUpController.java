package teamchat.web.controllers.sign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import teamchat.service.UserService;

@Controller
@RequestMapping(SignUpController.URI)
public class SignUpController {
	
	protected final static String URI="/signup";
	
	private UserService userService;

	@Autowired
	public SignUpController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@RequestMapping(path= {"","/","/**"})
	public String showAboutPage() {
		return "signup";
		
	}
	

}
