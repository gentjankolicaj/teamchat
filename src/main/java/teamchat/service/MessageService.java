package teamchat.service;

import java.util.List;

import teamchat.data.domain.Message;
import teamchat.data.domain.Team;
import teamchat.data.domain.User;

/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface MessageService {

	
	public abstract List<Message> getAll() throws Exception;
	public abstract List<Message> getAllById(List<Long> ids)  throws Exception;
	public abstract Message getById(Long id) throws Exception;
	
	public abstract Message create(Message entity) throws Exception;
	public abstract List<Message> createAll(List<Message> entities) throws Exception;
	
	public abstract Message edit(Message entity) throws Exception;
	public abstract List<Message> editAll(List<Message> entities) throws Exception;
	
	public abstract void deleteById(Long id) throws Exception;
	public abstract void delete(Message entity) throws Exception;
	public abstract void deleteAll(List<Message> entities) throws Exception;
	
	public abstract boolean existById(Long id) throws Exception;
	
	
	public abstract List<Message> getAllDeleted() throws Exception ;
	
	public abstract List<Message> getAllUnDeleted() throws Exception ;
	
	public abstract List<Message> getBySenderId(Long senderId) throws Exception ;
	
	public abstract List<Message> getByReceiverId(Long receiverId) throws Exception ;
	
	public abstract List<Message> getByTeamId(Long teamId) throws Exception ;
	
	public abstract int deleteBySenderId(Long senderId) throws Exception;
	
	public abstract int deleteByReceiverId(Long receiverId) throws Exception;
	
	public abstract int deleteByTeamId(Long teamId) throws Exception;
	
	
	public abstract Message sendMessage(User sender,User receiver,String message) throws Exception;
	
	public abstract Message sendMessage(User sender,Team team,String message) throws Exception;
	
	public abstract Message sendMessage(Message message) throws Exception;
	
	
	
}
