package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.Industry;



/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface IndustryDao {
	
	public abstract List<Industry> findAll() throws Exception;
	
	public abstract Industry findById(Long id) throws Exception ;
	
	public abstract List<Industry> findByName(String name) throws Exception;

	public abstract void save(Industry industry) throws Exception;
	
	public abstract void update(Industry industry) throws Exception;
	
	public abstract void delete(Industry industry) throws Exception;
	
	public abstract int deleteById(Long id) throws Exception;

}
