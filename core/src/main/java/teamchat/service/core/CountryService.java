package teamchat.service.core;

import java.util.List;

import teamchat.data.domain.Country;



/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface CountryService {
	
	public abstract List<Country> findAll() throws Exception ;

}
