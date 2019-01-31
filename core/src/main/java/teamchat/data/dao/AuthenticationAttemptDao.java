package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.AuthenticationAttempt;


/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface AuthenticationAttemptDao extends CrudDao<AuthenticationAttempt,Long>{
	
    public abstract List<AuthenticationAttempt> findByUserId(Long userId) throws Exception; 
    
}
