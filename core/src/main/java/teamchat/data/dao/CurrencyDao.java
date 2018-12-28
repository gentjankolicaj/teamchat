package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.Currency;



/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface CurrencyDao {

	
    public abstract List<Currency> findAll() throws Exception;
	
	public abstract Currency findById(Long Id) throws Exception ;
	
	public abstract List<Currency> findByName(String name) throws Exception;

	public abstract void save(Currency currency) throws Exception;
	
	public abstract void update(Currency currency) throws Exception;
	
	public abstract void delete(Currency currency) throws Exception;
	
	public abstract int deleteById(Long id) throws Exception;
	
}
