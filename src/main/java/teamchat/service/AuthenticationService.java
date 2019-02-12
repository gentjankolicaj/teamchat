package teamchat.service;

import teamchat.data.domain.User;

/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface AuthenticationService {
	
	public abstract User authenticate(String email,String password) throws Exception;

}
