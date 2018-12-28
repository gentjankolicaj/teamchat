package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.Country;


/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface CountryDao {

	
    public abstract List<Country> findAll() throws Exception;
	
	public abstract Country findById(Long Id) throws Exception ;
	
	public abstract void save(Country country) throws Exception;
	
	public abstract void update(Country country) throws Exception;
	
	public abstract void delete(Country country) throws Exception;
	
	public abstract int deleteById(Long id) throws Exception;
}
