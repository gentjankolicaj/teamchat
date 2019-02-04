package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.Message;


/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface MessageDao extends CrudDao<Message,Long> {

	
	public abstract List<Message> customFindAllDeleted() throws Exception ;
	
	public abstract List<Message> customFindAllUnDeleted() throws Exception ;
	
	public abstract List<Message> customFindBySenderId(Long senderId) throws Exception ;
	
	public abstract List<Message> customFindByReceiverId(Long receiverId) throws Exception ;
	
	public abstract List<Message> customFindByTeamId(Long teamId) throws Exception ;
	
	public abstract int customDeleteBySenderId(Long senderId) throws Exception;
	
	public abstract int customDeleteByReceiverId(Long receiverId) throws Exception;
	
	public abstract int customDeleteByTeamId(Long teamId) throws Exception;
	
}
