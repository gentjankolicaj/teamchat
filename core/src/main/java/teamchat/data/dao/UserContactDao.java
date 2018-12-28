package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.UserContact;


/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface UserContactDao {

	
	public abstract List<UserContact> findAll() throws Exception;
	
	public abstract UserContact findById(Long Id) throws Exception ;
	
	public abstract List<UserContact> findByEmail(String email)throws Exception;
	
	public abstract List<UserContact> findByTelephone(Long telephone)throws Exception;

	public abstract List<UserContact> findByMobile(Long mobile)throws Exception;

	public abstract void save(UserContact userContact) throws Exception;
	
	public abstract void update(UserContact userContact) throws Exception;
	
	public abstract void delete(UserContact userContact) throws Exception;
	
	public abstract int deleteById(Long Id) throws Exception;
	
}
