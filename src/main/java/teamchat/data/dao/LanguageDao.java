package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.Language;


/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface LanguageDao extends CrudDao<Language,Long> {
	
	public abstract List<Language> findByLang(String lang) throws Exception;

}
