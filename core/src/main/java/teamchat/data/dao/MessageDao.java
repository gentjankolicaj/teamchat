package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.Message;


/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface MessageDao extends CrudDao<Message,Long> {

	public abstract List<Message> findBySenderId(Long senderId) throws Exception ;
	
	public abstract List<Message> findByReceiverId(Long receiverId) throws Exception ;
	
	public abstract List<Message> findByTeamId(Long teamId) throws Exception ;
	
	public abstract int deleteBySenderId(Long senderId) throws Exception;
	
	public abstract int deleteByReceiverId(Long receiverId) throws Exception;
	
	public abstract int deleteByTeamId(Long teamId) throws Exception;
	
}
