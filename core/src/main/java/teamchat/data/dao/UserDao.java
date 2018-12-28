package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.User;


/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface UserDao {

	public abstract List<User> findAll() throws Exception;
	
	public abstract User findById(Long userId) throws Exception ;
	
	public abstract List<User> findByUserType(Long userTypeId) throws Exception;
	
	public abstract List<User> findByFirstName(String firstName) throws Exception;
	
	public abstract List<User> findByLastName(String lastName) throws Exception;
	
	
	public abstract void save(User user) throws Exception;
	
	public abstract void update(User user) throws Exception;
	
	public abstract void delete(User user) throws Exception;
	
	public abstract int deleteById(Long userId) throws Exception;
	
	
}
