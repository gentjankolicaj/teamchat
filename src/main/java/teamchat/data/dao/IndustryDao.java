package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.Industry;



/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface IndustryDao extends CrudDao<Industry,Long> {

	public abstract List<Industry> findByNameLike(String name) throws Exception;

}
