package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.User;


/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface UserDao extends CrudDao<User,Long> {
	
	public abstract List<User> findUsersByFirstNameLike(String firstName) throws Exception;
	
	public abstract List<User> findUsersByLastNameLike(String lastName) throws Exception;
	
	public abstract List<User> findUsersByUsernameLike(String username) throws Exception;
	
	public abstract List<User> findUsersByUsername(String username) throws Exception;
	

	
}
