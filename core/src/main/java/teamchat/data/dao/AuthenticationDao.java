package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.Authentication;



/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface AuthenticationDao {

	

	   public abstract List<Authentication> findAll() throws Exception;
		
		public abstract Authentication findById(Long id) throws Exception ;
		
		public abstract void save(Authentication authentication) throws Exception;
		
		public abstract void update(Authentication authentication) throws Exception;
		
		public abstract void delete(Authentication authentication) throws Exception;
		
		public abstract int deleteById(Long id) throws Exception;
		
	    public abstract Authentication findByUserId(Long userId) throws Exception; 
}
