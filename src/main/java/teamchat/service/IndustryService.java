package teamchat.service;

import java.util.List;

import teamchat.data.domain.Industry;


/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface IndustryService {
	
	public abstract List<Industry> findAll() throws Exception;
	public abstract List<Industry> findAllById(List<Long> ids)  throws Exception;
	public abstract Industry findById(Long id) throws Exception;
	
	public abstract Industry save(Industry entity) throws Exception;
	public abstract List<Industry> saveAll(List<Industry> entities) throws Exception;
	
	public abstract Industry update(Industry entity) throws Exception;
	public abstract List<Industry> updateAll(List<Industry> entities) throws Exception;
	
	public abstract void deleteById(Long id) throws Exception;
	public abstract void delete(Industry entity) throws Exception;
	public abstract void deleteAll(List<Industry> entities) throws Exception;
	
	public abstract boolean existById(Long id) throws Exception;
	
	//=================================
	public abstract List<Industry> findIndustryByNameLike(String name) throws Exception;

}
