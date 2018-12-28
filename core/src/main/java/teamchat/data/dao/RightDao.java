package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.Right;


/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface RightDao {

	
	        public abstract List<Right> findAll() throws Exception;
		
			public abstract Right findById(Long id) throws Exception ;
			
		    public abstract void save(Right right) throws Exception;
			
			public abstract void update(Right right) throws Exception;
			
			public abstract void delete(Right right) throws Exception;
			
			public abstract int deleteById(Long id) throws Exception;
}
