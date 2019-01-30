package teamchat.data.dao.impl;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teamchat.data.dao.UserDao;
import teamchat.data.domain.User;


/**
 * 
 * @author gentjan kolicaj
 *
 */
@Repository
public class UserDaoImpl implements UserDao {
	
	
	private SessionFactory sessionFactory;

	
	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	
	@Override
	public List<User> findAll() throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="from User order by id";
		Query<User> query=session.createQuery(hql,User.class);
		return query.getResultList();
	}

	@Override
	public User findById(Long userId) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		User user=session.get(User.class, userId);
		
		return user;
	}

	@Override
	public void save(User user) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.save(user);

	}

	@Override
	public void update(User user) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);

	}

	@Override
	public void delete(User user) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.delete(user);

	}

	@Override
	public int deleteById(Long userId) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="delete from User U where U.id=:var";
		Query<User> query=session.createQuery(hql,User.class);
		query.setParameter("var", userId);
		
		return query.executeUpdate();
	}


	@Override
	public List<User> findByUserType(Long userTypeId) throws Exception {
		Session session= sessionFactory.getCurrentSession();
		String hql="from User where user_type=:var";
		Query<User> query=session.createQuery(hql,User.class);
		query.setParameter("var", userTypeId);
			return query.getResultList();
	}


	@Override
	public List<User> findByFirstName(String firstName) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="from User U where U.firstName like :var";
		Query<User> query=session.createQuery(hql,User.class);
		query.setParameter("var", firstName+"%");
		return  query.getResultList();
	}


	@Override
	public List<User> findByLastName(String lastName) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="from User U where U.lastName like :var";
		Query<User> query=session.createQuery(hql,User.class);
		query.setParameter("var", lastName+"%");
		
		return query.getResultList();
	}
	
	

}
