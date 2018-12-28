package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.Chat;


/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface ChatDao {

	
   public abstract List<Chat> findAll() throws Exception;
	
	public abstract Chat findById(Long id) throws Exception ;
	
	public abstract List<Chat> findBySenderId(Long senderId) throws Exception ;
	
	public abstract List<Chat> findByReceiverId(Long receiverId) throws Exception ;
	
	public abstract List<Chat> findByTeamId(Long teamId) throws Exception ;

	public abstract void save(Chat chat) throws Exception;
	
	public abstract void update(Chat chat) throws Exception;
	
	public abstract void delete(Chat chat) throws Exception;
	
	public abstract int deleteById(Long id) throws Exception;
	
	public abstract int deleteBySenderId(Long senderId) throws Exception;
	
	public abstract int deleteByReceiverId(Long receiverId) throws Exception;
	
	public abstract int deleteByTeamId(Long teamId) throws Exception;
}
