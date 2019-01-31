package teamchat.service.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import teamchat.data.dao.IndustryDao;
import teamchat.data.domain.Industry;


/**
 * 
 * @author gentjan kolicaj
 *
 */
@Service
public class IndustryServiceImpl implements IndustryService{
	
		
	private IndustryDao industryDao;
	
	
    @Autowired
	public IndustryServiceImpl(IndustryDao industryDao) {
		super();
		this.industryDao = industryDao;
	}



    @Transactional
	@Override
	public List<Industry> findAll() throws Exception {
		return industryDao.findAll();
	}

}
