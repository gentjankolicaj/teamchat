package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.Team;



/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface TeamDao {

	

	   public abstract List<Team> findAll() throws Exception;
		
		public abstract Team findById(Long id) throws Exception ;
		
		public abstract List<Team> findByName(String name) throws Exception;
		
		public abstract List<Team> findByDepartmentId(Long departmentId) throws Exception;

		public abstract void save(Team team) throws Exception;
		
		public abstract void update(Team team) throws Exception;
		
		public abstract void delete(Team team) throws Exception;
		
		public abstract int deleteById(Long id) throws Exception;
}
