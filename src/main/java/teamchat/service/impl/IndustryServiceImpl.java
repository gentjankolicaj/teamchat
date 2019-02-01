package teamchat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import teamchat.data.dao.IndustryDao;
import teamchat.data.domain.Industry;
import teamchat.service.IndustryService;


/**
 * 
 * @author gentjan kolicaj
 *
 */
@Service
@Transactional
public class IndustryServiceImpl implements IndustryService{
		
	private IndustryDao industryDao;
	
    @Autowired
	public IndustryServiceImpl(IndustryDao industryDao) {
		super();
		this.industryDao = industryDao;
	}

	@Override
	public List<Industry> findAll() throws Exception {
		return industryDao.findAll();
	}

	@Override
	public List<Industry> findAllById(List<Long> ids) throws Exception {
	  return industryDao.findAllById(ids);
	}

	@Override
	public Industry findById(Long id) throws Exception {
		return industryDao.findById(id);
	}

	@Override
	public Industry save(Industry entity) throws Exception {
		return industryDao.save(entity);
	}

	@Override
	public List<Industry> saveAll(List<Industry> entities) throws Exception {
		return industryDao.saveAll(entities);
	}

	@Override
	public Industry update(Industry entity) throws Exception {
		return industryDao.update(entity);
	}

	@Override
	public List<Industry> updateAll(List<Industry> entities) throws Exception {
		return industryDao.updateAll(entities);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		industryDao.deleteById(id);
		
	}

	@Override
	public void delete(Industry entity) throws Exception {
		industryDao.delete(entity);
		
	}

	@Override
	public void deleteAll(List<Industry> entities) throws Exception {
		industryDao.deleteAll(entities);
		
	}

	@Override
	public boolean existById(Long id) throws Exception {
		return industryDao.existById(id);
	}

	@Override
	public List<Industry> findIndustryByNameLike(String name) throws Exception {
		return industryDao.findIndustryByNameLike(name);
	}

	


  

}
