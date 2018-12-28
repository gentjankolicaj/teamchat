package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.Attempt;


/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface AttemptDao {
	
   public abstract List<Attempt> findAll() throws Exception;
	
	public abstract Attempt findById(Long id) throws Exception ;
	
	public abstract void save(Attempt attempt) throws Exception;
	
	public abstract void update(Attempt attempt) throws Exception;
	
	public abstract void delete(Attempt attempt) throws Exception;
	
	public abstract int deleteById(Long id) throws Exception;
	
    public abstract List<Attempt> findByUserId(Long userId) throws Exception; 
}
