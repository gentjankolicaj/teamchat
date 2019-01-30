package teamchat.data.dao.impl;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teamchat.data.dao.UserTypeDao;
import teamchat.data.domain.UserType;



/**
 * 
 * @author gentjan kolicaj
 *
 */
@Repository
public class UserTypeDaoImpl implements UserTypeDao {
	
	
	private SessionFactory sessionFactory;

	@Autowired
	public UserTypeDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<UserType> findAll() throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="from UserType";
		
		Query<UserType> query=session.createQuery(hql,UserType.class);
	return query.getResultList();
	}

	@Override
	public UserType findById(Long id) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		UserType userType=session.get(UserType.class, id);
		
		return userType;
	}

	@Override
	public List<UserType> findByType(String type) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="from UserType U where U.userType like :var";
		Query<UserType> query=session.createQuery(hql,UserType.class);
		query.setParameter("var", type);
		return query.getResultList();
	}

	@Override
	public void save(UserType userType) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.save(userType);
		
	}

	@Override
	public void update(UserType userType) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(userType);;
		
	}

	@Override
	public void delete(UserType userType) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.delete(userType);
		
	}

	@Override
	public int deleteById(Long id) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="delete from UserType U where U.id=:var";
		Query<UserType> query=session.createQuery(hql,UserType.class);
		query.setParameter("var", id);
		return query.executeUpdate();
	}
	
	
	

}
