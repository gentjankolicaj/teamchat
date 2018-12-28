package teamchat.data.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teamchat.data.domain.UserContact;


/**
 * 
 * @author gentjan kolicaj
 *
 */
@Repository
public class UserContactDaoImpl implements UserContactDao{
	
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public UserContactDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	

	@Override
	public List<UserContact> findAll() throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="from UserContact order by id";
		Query<UserContact> query=session.createQuery(hql,UserContact.class);
		
	  return query.getResultList();
	 
	}

	@Override
	public UserContact findById(Long id) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		UserContact userContact=session.get(UserContact.class, id);
		return userContact;
	}

	@Override
	public void save(UserContact userContact) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.save(userContact);
		
	}

	@Override
	public void update(UserContact userContact) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(userContact);;
	}

	@Override
	public void delete(UserContact userContact) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.delete(userContact);
		
	}

	@Override
	public int deleteById(Long id) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="delete from UserContact U where U.id=:var";
		Query query=session.createQuery(hql);
		query.setParameter("var", id);
		return query.executeUpdate();
	}



	@Override
	public List<UserContact> findByEmail(String email) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="from UserContact U where U.email like :var";
		Query<UserContact> query=session.createQuery(hql,UserContact.class);
		query.setParameter("var", email+"%");
		return query.getResultList();
	}



	@Override
	public List<UserContact> findByTelephone(Long telephone) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="from UserContact U where U.telephone like :var";
		Query<UserContact> query=session.createQuery(hql,UserContact.class);
		query.setParameter("var", telephone+"%");
		return query.getResultList();
	}



	@Override
	public List<UserContact> findByMobile(Long mobile) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="from UserContact U where U.mobile like :var";
		Query<UserContact> query=session.createQuery(hql,UserContact.class);
		query.setParameter("var", mobile+"%");
		return query.getResultList();
	}

	
	
}
