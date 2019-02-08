package teamchat.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import teamchat.data.domain.User;
import teamchat.service.MessageService;
import teamchat.service.UserService;

@Controller
@RequestMapping(AccountController.URI)
class AccountController {
	
	protected static final String URI="/account";
	
	private User user;
	
	private UserService userService;
	private MessageService messageService;
	
	@Autowired
	public AccountController(UserService userService, MessageService messageService) {
		super();
		this.userService = userService;
		this.messageService = messageService;
	}
	

    @RequestMapping(path= {"","/","/**"})
	public String showAccount(Model model) {
    	
    	return "account";
    }
	
	
}
