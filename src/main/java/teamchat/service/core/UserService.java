package teamchat.service.core;

import java.util.List;

import teamchat.data.domain.User;



/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface UserService {

	
	public abstract List<User> findAll() throws Exception;
	
	
}
