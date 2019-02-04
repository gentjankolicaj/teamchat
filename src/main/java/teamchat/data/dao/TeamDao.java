package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.Team;



/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface TeamDao extends CrudDao<Team,Long> {
	
	public abstract List<Team> findByNameLike(String name) throws Exception;
		
	public abstract List<Team> findByDepartmentId(Long departmentId) throws Exception;
		
}
