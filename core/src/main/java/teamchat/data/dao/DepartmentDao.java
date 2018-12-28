package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.Department;



/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface DepartmentDao {

	
	   public abstract List<Department> findAll() throws Exception;
		
		public abstract Department findById(Long id) throws Exception ;
		
		public abstract List<Department> findByName(String name) throws Exception;
		
		public abstract List<Department> findByCreatorId(Long creatorId) throws Exception;

		public abstract void save(Department department) throws Exception;
		
		public abstract void update(Department department) throws Exception;
		
		public abstract void delete(Department department) throws Exception;
		
		public abstract int deleteById(Long id) throws Exception;
		
}
