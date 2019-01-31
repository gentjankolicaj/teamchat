package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.Privilege;

/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface PrivilegeDao extends CrudDao<Privilege,Long>{

	public abstract List<Privilege> findPrivilegesByIdentifierLike(String identifier) throws Exception;

}
