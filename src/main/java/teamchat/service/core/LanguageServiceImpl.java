package teamchat.service.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teamchat.data.dao.LanguageDao;
import teamchat.data.domain.Language;


/**
 * 
 * @author gentjan kolicaj
 *
 */
@Service
public class LanguageServiceImpl implements LanguageService {
	
	
	private LanguageDao languageDao;
	

	
    @Autowired
	public LanguageServiceImpl(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}



	@Override
	public List<Language> findAll() throws Exception {
		return languageDao.findAll();
	}

}
