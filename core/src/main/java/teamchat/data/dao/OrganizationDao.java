package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.Organization;


/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface OrganizationDao {
	
	    public abstract List<Organization> findAll() throws Exception;
		
		public abstract Organization findById(Long id) throws Exception ;
		
	    public abstract void save(Organization organization) throws Exception;
		
		public abstract void update(Organization organization) throws Exception;
		
		public abstract void delete(Organization organization ) throws Exception;
		
		public abstract int deleteById(Long id) throws Exception;

}
