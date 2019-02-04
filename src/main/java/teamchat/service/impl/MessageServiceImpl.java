package teamchat.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import teamchat.data.dao.MessageDao;
import teamchat.data.domain.Message;
import teamchat.data.domain.Team;
import teamchat.data.domain.User;
import teamchat.service.MessageService;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@Service
@Transactional
public class MessageServiceImpl implements MessageService {
	
	private MessageDao messageDao;
	
	@Autowired
	public MessageServiceImpl(MessageDao messageDao) {
		this.messageDao=messageDao;
	}

	@Override
	public List<Message> getAll() throws Exception {
		return messageDao.findAll();
	}

	@Override
	public List<Message> getAllById(List<Long> ids) throws Exception {
		return messageDao.findAllById(ids);
	}

	@Override
	public Message getById(Long id) throws Exception {
		return messageDao.findById(id);
	}

	@Override
	public Message create(Message entity) throws Exception {
	return messageDao.save(entity);
	}

	@Override
	public List<Message> createAll(List<Message> entities) throws Exception {
		return messageDao.saveAll(entities);
	}

	@Override
	public Message edit(Message entity) throws Exception {
		return messageDao.update(entity);
	}

	@Override
	public List<Message> editAll(List<Message> entities) throws Exception {
		return messageDao.updateAll(entities);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		messageDao.deleteById(id);
		
	}

	@Override
	public void delete(Message entity) throws Exception {
		messageDao.delete(entity);
		
	}

	@Override
	public void deleteAll(List<Message> entities) throws Exception {
		messageDao.deleteAll(entities);
		
	}

	@Override
	public boolean existById(Long id) throws Exception {
		return messageDao.existById(id);
	}


	@Override
	public Message sendMessage(User sender, User receiver, String message) throws Exception {
		Message newMessage=new Message();
		newMessage.setTeam(null);
		newMessage.setSender(sender);
		newMessage.setReceiver(receiver);
		newMessage.setMessage(message);
		newMessage.setCreationDate(new Date());
		newMessage.setDeletionDate(null);
		newMessage.setModificationDate(null);
		newMessage.setModifiedBy(null);
		
		return messageDao.save(newMessage);
	}

	@Override
	public Message sendMessage(User sender, Team team, String message) throws Exception {
		Message newMessage=new Message();
		newMessage.setTeam(team);
		newMessage.setSender(sender);
		newMessage.setReceiver(null);
		newMessage.setMessage(message);
		newMessage.setCreationDate(new Date());
		newMessage.setDeletionDate(null);
		newMessage.setModificationDate(null);
		newMessage.setModifiedBy(null);
		
		return messageDao.save(newMessage);
	}

	@Override
	public List<Message> getAllDeleted() throws Exception {
		return messageDao.customFindAllDeleted();
	}

	@Override
	public List<Message> getAllUnDeleted() throws Exception {
		return messageDao.customFindAllUnDeleted();
	}

	@Override
	public List<Message> getBySenderId(Long senderId) throws Exception {
		return messageDao.customFindBySenderId(senderId);
	}

	@Override
	public List<Message> getByReceiverId(Long receiverId) throws Exception {
		return messageDao.customFindByReceiverId(receiverId);
	}

	@Override
	public List<Message> getByTeamId(Long teamId) throws Exception {
		return messageDao.customFindByTeamId(teamId);
	}

	@Override
	public int deleteBySenderId(Long senderId) throws Exception {
		return messageDao.customDeleteBySenderId(senderId);
	}

	@Override
	public int deleteByReceiverId(Long receiverId) throws Exception {
		return messageDao.customDeleteByReceiverId(receiverId);
	}

	@Override
	public int deleteByTeamId(Long teamId) throws Exception {
		return messageDao.customDeleteByTeamId(teamId);
	}



}
