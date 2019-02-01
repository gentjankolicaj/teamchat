package teamchat.service;

import java.util.List;

import teamchat.data.domain.AuthenticationAttempt;

/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface AuthenticationAttemptService {

	public abstract List<AuthenticationAttempt> getAll() throws Exception;
	public abstract List<AuthenticationAttempt> getAllById(List<Long> ids)  throws Exception;
	public abstract AuthenticationAttempt getById(Long id) throws Exception;
	
	public abstract AuthenticationAttempt create(AuthenticationAttempt entity) throws Exception;
	public abstract List<AuthenticationAttempt> createAll(List<AuthenticationAttempt> entities) throws Exception;
	
	public abstract AuthenticationAttempt edit(AuthenticationAttempt entity) throws Exception;
	public abstract List<AuthenticationAttempt> editAll(List<AuthenticationAttempt> entities) throws Exception;
	
	public abstract void deleteById(Long id) throws Exception;
	public abstract void delete(AuthenticationAttempt entity) throws Exception;
	public abstract void deleteAll(List<AuthenticationAttempt> entities) throws Exception;
	
	public abstract boolean existById(Long id) throws Exception;
	
	//=========================================================
	public abstract List<AuthenticationAttempt> getByUserId(Long userId) throws Exception; 
	
}
