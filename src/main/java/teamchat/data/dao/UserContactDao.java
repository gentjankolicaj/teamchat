package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.UserContact;


/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface UserContactDao extends CrudDao<UserContact,Long>{

	public abstract UserContact findByEmail(String email)throws Exception;
	
	public abstract List<UserContact> findByEmailLike(String email)throws Exception;
	
	public abstract List<UserContact> findByTelephone(Long telephone)throws Exception;

	public abstract List<UserContact> findByMobile(Long mobile)throws Exception;
	
}
