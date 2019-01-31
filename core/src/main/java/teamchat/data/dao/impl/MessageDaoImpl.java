package teamchat.data.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teamchat.data.dao.MessageDao;
import teamchat.data.domain.Message;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@Repository
public class MessageDaoImpl implements MessageDao {

	private SessionFactory sessionFactory;

	@Autowired
	public MessageDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Message> findAll() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Message";
		Query<Message> query = session.createQuery(hql, Message.class);

		return query.getResultList();
	}

	@Override
	public Message findById(Long id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Message chat = session.get(Message.class, id);
		return chat;
	}

	@Override
	public Message save(Message message) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.save(message);

		return message;

	}

	@Override
	public Message update(Message message) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(message);
		return message;

	}

	@Override
	public void delete(Message message) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.delete(message);

	}

	@Override
	public void deleteById(Long id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from Message M where M.id=:var";
		Query<Message> query = session.createQuery(hql, Message.class);
		query.setParameter("var", id);
		query.executeUpdate();
	}

	@Override
	public List<Message> findBySenderId(Long senderId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Message M where M.sender=:var";
		Query<Message> query = session.createQuery(hql, Message.class);
		query.setParameter("var", senderId);
		return query.getResultList();
	}

	@Override
	public List<Message> findByReceiverId(Long receiverId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Message M where M.receiver=:var";
		Query<Message> query = session.createQuery(hql, Message.class);
		query.setParameter("var", receiverId);
		return query.getResultList();
	}

	@Override
	public List<Message> findByTeamId(Long teamId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Message M where M.team_id=:var";
		Query<Message> query = session.createQuery(hql, Message.class);
		query.setParameter("var", teamId);
		return query.getResultList();
	}

	@Override
	public int deleteBySenderId(Long senderId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from Message M where  M.sender=:var";
		Query<Message> query = session.createQuery(hql, Message.class);
		query.setParameter("var", senderId);

		return query.executeUpdate();
	}

	@Override
	public int deleteByReceiverId(Long receiverId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from Message M where M.receiver=:var";
		Query<Message> query = session.createQuery(hql, Message.class);
		query.setParameter("var", receiverId);
		return query.executeUpdate();
	}

	@Override
	public int deleteByTeamId(Long teamId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from Message where M.team_id=:var";
		Query<Message> query = session.createQuery(hql, Message.class);
		query.setParameter("var", teamId);
		return query.executeUpdate();
	}

	@Override
	public List<Message> findAllById(List<Long> ids) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Message> list = new ArrayList<>(ids.size());
		for (Long id : ids) {
			Message tmp = session.get(Message.class, id);
			list.add(tmp);
		}
		return list;
	}

	@Override
	public List<Message> saveAll(List<Message> entities) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		for (Message tmp : entities)
			session.save(tmp);
		return entities;
	}

	@Override
	public List<Message> updateAll(List<Message> entities) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		for (Message tmp : entities)
			session.saveOrUpdate(tmp);
		return entities;
	}

	@Override
	public void deleteAll(List<Message> entities) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		for (Message tmp : entities)
			session.delete(tmp);

	}

	@Override
	public boolean existById(Long id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Message tmp = session.get(Message.class, id);
		if (tmp != null)
			return true;
		else
			return false;
	}

}