package teamchat.service;

import java.util.List;

import teamchat.data.domain.User;



/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface UserService {

	public abstract List<User> findAll() throws Exception;
	public abstract List<User> findAllById(List<Long> ids)  throws Exception;
	public abstract User findById(Long id) throws Exception;
	
	public abstract User save(User entity) throws Exception;
	public abstract List<User> saveAll(List<User> entities) throws Exception;
	
	public abstract User update(User entity) throws Exception;
	public abstract List<User> updateAll(List<User> entities) throws Exception;
	
	public abstract void deleteById(Long id) throws Exception;
	public abstract void delete(User entity) throws Exception;
	public abstract void deleteAll(List<User> entities) throws Exception;
	
	public abstract boolean existById(Long id) throws Exception;
	
	//==================================================================
    public abstract List<User> findUsersByFirstNameLike(String firstName) throws Exception;
	
	public abstract List<User> findUsersByLastNameLike(String lastName) throws Exception;
	
	public abstract List<User> findUsersByUsernameLike(String username) throws Exception;
	
	public abstract List<User> findUsersByUsername(String username) throws Exception;

	
	
}
