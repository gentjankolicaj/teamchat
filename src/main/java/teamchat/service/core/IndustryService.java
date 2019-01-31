package teamchat.service.core;

import java.util.List;

import teamchat.data.domain.Industry;


/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface IndustryService {
	
	public abstract List<Industry> findAll() throws Exception ;

}
