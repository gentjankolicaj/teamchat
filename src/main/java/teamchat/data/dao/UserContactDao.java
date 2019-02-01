package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.UserContact;


/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface UserContactDao extends CrudDao<UserContact,Long>{

	public abstract UserContact findUserContactByEmail(String email)throws Exception;
	
	public abstract List<UserContact> findUserContactByEmailLike(String email)throws Exception;
	
	public abstract List<UserContact> findUserContactByTelephone(Long telephone)throws Exception;

	public abstract List<UserContact> findUserContactByMobile(Long mobile)throws Exception;
	
}
