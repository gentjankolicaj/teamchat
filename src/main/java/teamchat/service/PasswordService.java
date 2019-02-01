package teamchat.service;

import java.util.List;

import teamchat.data.domain.Credential;
import teamchat.data.domain.User;
import teamchat.security.HashFunction;

/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface PasswordService {
	

	public abstract String hashPassword(String password,HashFunction function) throws Exception;
	
	public abstract List<String> hashPasswords(List<String> passwords,HashFunction function) throws Exception;
	
	public abstract User hashPassword(User user ,HashFunction function) throws Exception;
	
	public abstract Credential hashPassword(Credential credential,HashFunction hashFunction) throws Exception;
	

}
