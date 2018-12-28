package teamchat.service.core;

import java.util.List;

import teamchat.data.domain.Language;



/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface LanguageService {
	
	public abstract List<Language> findAll() throws Exception ;

}
