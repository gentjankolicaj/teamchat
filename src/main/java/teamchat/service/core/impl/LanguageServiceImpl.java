package teamchat.service.core.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teamchat.data.dao.LanguageDao;
import teamchat.data.domain.Language;
import teamchat.service.core.LanguageService;


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
