package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.Group;

/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface GroupDao extends CrudDao<Group,Long>{
	
	public abstract List<Group> findByNameLike(String name) throws Exception;

}
