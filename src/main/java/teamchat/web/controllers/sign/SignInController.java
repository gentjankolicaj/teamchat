package teamchat.web.controllers.sign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import teamchat.service.AuthenticationService;

@Controller
@RequestMapping(SignInController.URI)
public class SignInController {
	
	protected final static String URI="/signin";
	
	private AuthenticationService authenticationService;

	@Autowired
	public SignInController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	
	@RequestMapping(path= {"","/","/**"})
	public String showAboutPage() {
		return "signin";
		
	}

	
	
	

}
