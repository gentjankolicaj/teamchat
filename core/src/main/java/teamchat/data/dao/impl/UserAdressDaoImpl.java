package teamchat.data.dao.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teamchat.data.dao.UserAdressDao;
import teamchat.data.domain.UserAdress;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@Repository
public class UserAdressDaoImpl implements UserAdressDao {

	private SessionFactory sessionFactory;

	@Autowired
	public UserAdressDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<UserAdress> findAll() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from UserAdress";
		Query<UserAdress> query = session.createQuery(hql, UserAdress.class);
		return query.getResultList();
	}

	@Override
	public UserAdress findById(Long id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		UserAdress userAdress = session.get(UserAdress.class, id);
		return userAdress;
	}

	@Override
	public List<UserAdress> findByCity(String cityName) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from UserAdress U where U.city like :var";
		Query<UserAdress> query = session.createQuery(hql, UserAdress.class);
		query.setParameter("var", cityName + "%");
		return query.getResultList();
	}

	@Override
	public List<UserAdress> findByStreet(String street) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from UserAdress U where U.street like :var";
		Query<UserAdress> query = session.createQuery(hql, UserAdress.class);
		query.setParameter("var", street + "%");
		return query.getResultList();

	}

	@Override
	public List<UserAdress> findByCountryId(Long countryId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from UserAdress where country_id=:var";
		Query<UserAdress> query = session.createQuery(hql, UserAdress.class);
		query.setParameter("var", countryId);
		return query.getResultList();
	}

	@Override
	public void save(UserAdress userAdress) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.save(userAdress);

	}

	@Override
	public void update(UserAdress userAdress) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(userAdress);

	}

	@Override
	public void delete(UserAdress userAdress) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.delete(userAdress);

	}

	@Override
	public int deleteById(Long id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from UserAdress U where U.id=:var";
		Query<UserAdress> query = session.createQuery(hql, UserAdress.class);
		query.setParameter("var", id);
		return query.executeUpdate();
	}

}
