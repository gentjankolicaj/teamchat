package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.UserType;



/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface UserTypeDao {
	
    public abstract List<UserType> findAll() throws Exception;
	
	public abstract UserType findById(Long id) throws Exception ;
	
	public abstract List<UserType> findByType(String type) throws Exception;

	public abstract void save(UserType userType) throws Exception;
	
	public abstract void update(UserType userType) throws Exception;
	
	public abstract void delete(UserType userType) throws Exception;
	
	public abstract int deleteById(Long id) throws Exception;

}
