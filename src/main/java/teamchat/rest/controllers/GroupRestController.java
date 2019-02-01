package teamchat.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import teamchat.data.domain.Group;
import teamchat.service.GroupService;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@RestController
@RequestMapping(GroupRestController.URI)
public class GroupRestController {

	public static final String URI = "/api/groups";

	@Autowired
	private GroupService groupService;

	@RequestMapping(path = { "", "/", "/all", "/list" }, produces = "application/json")
	public List<Group> getAll() {
		try {
			
			return groupService.getAll();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
