package teamchat.service.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import teamchat.data.dao.CountryDao;
import teamchat.data.domain.Country;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@Service
public class CountryServiceImpl implements CountryService{
	
	private final CountryDao countryDao;
	
	@Autowired
	public CountryServiceImpl(CountryDao countryDao) {
		this.countryDao=countryDao;
	}

	@Transactional
	@Override
	public List<Country> findAll() throws Exception {
		return countryDao.findAll();
	}
	


}
