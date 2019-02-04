package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.User;


/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface UserDao extends CrudDao<User,Long> {
	
	public abstract List<User> findByFirstNameLike(String firstName) throws Exception;
	public abstract List<User> findByLastNameLike(String lastName) throws Exception;
	public abstract List<User> findByUsernameLike(String username) throws Exception;
	public abstract List<User> findByUsername(String username) throws Exception;
	
    public abstract List<User> findAllDeleted() throws Exception ;
	public abstract List<User> findAllUnDeleted() throws Exception ;
	

	
}
