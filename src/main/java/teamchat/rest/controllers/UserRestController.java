package teamchat.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import teamchat.data.domain.User;
import teamchat.service.core.UserService;


/**
 * 
 * @author gentjan kolicaj
 *
 */
@RestController
@RequestMapping("/api/rest/users")
public class UserRestController {
	
	
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
