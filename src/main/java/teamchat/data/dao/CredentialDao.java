package teamchat.data.dao;

import teamchat.data.domain.Credential;

/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface CredentialDao extends CrudDao<Credential,Long> {

	    public abstract Credential findByUserId(Long userId) throws Exception; 
}
