package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.Language;


/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface LanguageDao {
	
    public abstract List<Language> findAll() throws Exception;
	
	public abstract Language findById(Long id) throws Exception ;
	
	public abstract List<Language> findByLang(String lang) throws Exception;

	public abstract void save(Language language) throws Exception;
	
	public abstract void update(Language language) throws Exception;
	
	public abstract void delete(Language language) throws Exception;
	
	public abstract int deleteById(Long id) throws Exception;

}
