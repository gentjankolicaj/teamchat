package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.Currency;



/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface CurrencyDao extends CrudDao<Currency,Long>{
	
	public abstract List<Currency> findByNameLike(String name) throws Exception;

}
