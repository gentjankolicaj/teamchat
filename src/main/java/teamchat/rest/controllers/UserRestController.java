package teamchat.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import teamchat.data.domain.User;
import teamchat.service.UserService;


/**
 * 
 * @author gentjan kolicaj
 *
 */
@RestController
@RequestMapping(UserRestController.URI)
public class UserRestController {
	
	public static final String URI="/api/users";
	
	
	@Autowired
	private UserService userService;

	
    @RequestMapping(path={"/","/all","/list"},produces="application/json" )
	public List<User> getUsers() {
		try {
	return userService.findAll();
	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
	
	

}
