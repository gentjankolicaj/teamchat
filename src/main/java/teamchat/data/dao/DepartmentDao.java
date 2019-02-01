package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.Department;



/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface DepartmentDao extends CrudDao<Department,Long>{

		public abstract List<Department> findDepartmentByName(String name) throws Exception;
		
		public abstract List<Department> findDepartmentByCreatorId(Long creatorId) throws Exception;

}
