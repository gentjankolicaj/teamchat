package teamchat.data.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teamchat.data.domain.Chat;


/**
 * 
 * @author gentjan kolicaj
 *
 */
@Repository
public class ChatDaoImpl implements ChatDao {
	

	private SessionFactory sessionFactory;
	
	
	@Autowired
	public ChatDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}


	@Override
	public List<Chat> findAll() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Chat";
		Query<Chat> query=session.createQuery(hql,Chat.class);
		
		return query.getResultList();
	}

	@Override
	public Chat findById(Long id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Chat chat=session.get(Chat.class, id);
		return chat;
	}

	@Override
	public void save(Chat chat) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.save(chat);
		
	}

	@Override
	public void update(Chat chat) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(chat);
		
	}

	@Override
	public void delete(Chat chat) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.delete(chat);
		
	}

	@Override
	public int deleteById(Long id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql="delete from Chat C where C.id=:var";
		Query<Chat> query=session.createQuery(hql,Chat.class);
		query.setParameter("var", id);
		return query.executeUpdate();
	}


	@Override
	public List<Chat> findBySenderId(Long senderId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql="from Chat where sender=:var";
		Query<Chat> query=session.createQuery(hql,Chat.class);
		query.setParameter("var",senderId);
		return query.getResultList();
	}


	@Override
	public List<Chat> findByReceiverId(Long receiverId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql="from Chat where receiver=:var";
		Query<Chat> query=session.createQuery(hql,Chat.class);
		query.setParameter("var", receiverId);
		return query.getResultList();
	}


	@Override
	public List<Chat> findByTeamId(Long teamId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql="from Chat where team_id=:var";
		Query<Chat> query=session.createQuery(hql,Chat.class);
		query.setParameter("var", teamId);
		return query.getResultList();
	}


	@Override
	public int deleteBySenderId(Long senderId) throws Exception {
         Session session=sessionFactory.getCurrentSession();
         String hql="delete from Chat where  sender=:var";
         Query<Chat> query=session.createQuery(hql,Chat.class);
         query.setParameter("var", senderId);
         
		return query.executeUpdate();
	}


	@Override
	public int deleteByReceiverId(Long receiverId) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="delete from Chat where receiver=:var";
		Query<Chat> query=session.createQuery(hql,Chat.class);
		query.setParameter("var", receiverId);
		return query.executeUpdate();
	}


	@Override
	public int deleteByTeamId(Long teamId) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="delete from Chat where team_id=:var";
		Query<Chat> query=session.createQuery(hql,Chat.class);
		query.setParameter("var", teamId);
		return query.executeUpdate();
	}

	

}
